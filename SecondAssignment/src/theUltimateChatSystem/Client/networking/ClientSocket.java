package theUltimateChatSystem.Client.networking;

import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.Request;
import theUltimateChatSystem.shared.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientSocket implements Client {
    private PropertyChangeSupport support;
    private String userName;


    public ClientSocket() {
        support = new PropertyChangeSupport(this);

    }

    public void startClient() {
        try {
            Socket socket = new Socket("localhost", 9009);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

            Thread t = new Thread(() -> listenToServer(inFromServer, outToServer));
            t.setDaemon(true);
            t.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Message> getMessages() {
        try {
            Request response = request(null, "getMessage");
            return (List<Message>) response.getArg();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getUserList() {

        try {
            Request response = request(null, "getUserList");
            return (List<String>) response.getArg();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUser(String username, String password) {
        User user = new User(username,password);
        try {
            Request response = request(user,"addUser");
            return (boolean) response.getArg();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isLoginPossible(User user) {
        try {
            Request response = request(user,"isLoginPossible");
           if( (boolean) response.getArg()){
               this.userName=user.getUserName();
           }
           return (boolean) response.getArg();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void listenToServer(ObjectInputStream inFromServer, ObjectOutputStream outToServer) {
        try {
            outToServer.writeObject(new Request("Listener", null));
            while (true) {
                Request response = (Request) inFromServer.readObject();
                if (response.getType().equals("addMessage")) {
                    support.firePropertyChange("addMessage", null, response.getArg());
                }
                 if (response.getType().equals("userRemoved")) {
                    support.firePropertyChange("userRemoved", null, response.getArg());
                } else if (response.getType().equals("userNameAdded")) {
                    support.firePropertyChange("userNameAdded", null, response.getArg());
                }


            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean isConnectionPossible(String username) {
        try {
            Request response = request(username, "connectionRequest");
           return (boolean) response.getArg();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void sendMessage(String message) {
        try {
            Message tempMessage = new Message(message, userName);
            Request response = request(tempMessage, "addMessage");
//              Message newMessage = (Message) response.getArg();
//             support.firePropertyChange("addMessage",null,newMessage);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Request request(Object arg, String type) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 9009);
        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
        outToServer.writeObject(new Request(type, arg));
        return (Request) inFromServer.readObject();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
