package theUltimateChatSystem.Server.networking;

import theUltimateChatSystem.Server.model.Model;
import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.MessageList;
import theUltimateChatSystem.shared.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
            while (true){
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
                    model.addMessage((Message) request.getArg());
                    pool.broadcastToAll((Message) request.getArg());
                     model.addListener("MessageAdded",this::messageAdded);
                    // outToClient.writeObject(new Request(null,null));
                    //  outToClient.writeObject(new Request());
                }
                else if ("Listener".equals(request.getType())){
                    model.addListener("MessageAdded",this::messageAdded);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void messageAdded(PropertyChangeEvent event) {
        Message temp = (Message) event.getNewValue();
        try {
            outToClient.writeObject(new Request("MessageAdded", temp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToClient(Message message) {

        model.addMessage(message);
        // outToClient.writeObject(new Request("messageAdded", message));
    }

    public String getUserName() {
        return userName;
    }
}
