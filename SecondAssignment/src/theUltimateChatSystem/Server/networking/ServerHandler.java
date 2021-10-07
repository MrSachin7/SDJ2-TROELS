package theUltimateChatSystem.Server.networking;

import theUltimateChatSystem.Server.model.Model;
import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ServerHandler implements Runnable {

    private Socket socket;
    private Model model;
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;
    private String userName;
    private ConnectionPool pool;

    public ServerHandler(Socket socket, Model model, ConnectionPool pool) {
        this.socket = socket;
        this.pool = pool;
        this.model = model;


        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Request request = (Request) inFromClient.readObject();
                if ("connectionRequest".equals(request.getType())) {
                    boolean result = false;
                    String temp = (String) request.getArg();
                    if (model.isConnectionPossible(temp)) {
                        userName = temp;
                        result = true;
                        model.addUserName(userName);
                    }
                    outToClient.writeObject(new Request("connectionRequest", result));
                } else if ("addMessage".equals(request.getType())) {
                    //  model.addListener("MessageAdded",this::messageAdded);
                    //  model.addMessage((Message) request.getArg());
                    pool.broadcastToAll((Message) request.getArg());
                    // model.addListener("MessageAdded",this::messageAdded);
                    // outToClient.writeObject(new Request(null,null));
                    //  outToClient.writeObject(new Request());
                } else if ("Listener".equals(request.getType())) {
                    model.addListener("MessageAdded", this::messageAdded);
                    model.addListener("userAdded", this::userAdded);
                    model.addListener("userRemoved", this::userRemoved);
                } else if ("getMessage".equals(request.getType())) {
                    List<Message> list = model.getMessages();
                    outToClient.writeObject(new Request("getMessage", list));
                }
                else if ("getUserList".equals(request.getType())){
                    List<String> list = model.getAllUsers();
                    outToClient.writeObject(new Request("getUserList",list));
                }
            }

        } catch (IOException e) {
            model.removeUserName(userName);
            System.out.println("Socket has been disconnected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void messageAdded(PropertyChangeEvent event) {
        Message temp = (Message) event.getNewValue();
        try {
            //  System.out.println(userName);
            outToClient.writeObject(new Request("MessageAdded", temp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToClient(Message message) {

        //  model.addMessage(message);
        try {
            outToClient.writeObject(new Request("MessageAdded", message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUserName() {
        return userName;
    }

    public void userAdded(PropertyChangeEvent event) {
        String username = (String) event.getNewValue();
        try {
            outToClient.writeObject(new Request("userAdded", username));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userRemoved(PropertyChangeEvent event) {
        String userName = (String) event.getNewValue();
        try {
            outToClient.writeObject(new Request("userRemoved", userName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
