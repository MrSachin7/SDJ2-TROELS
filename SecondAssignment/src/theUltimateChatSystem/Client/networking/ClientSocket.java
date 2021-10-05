package theUltimateChatSystem.Client.networking;

import com.sun.webkit.ThemeClient;
import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.MessageList;
import theUltimateChatSystem.shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket implements Client {
    private PropertyChangeSupport support;
    private String userName;

    public ClientSocket() {
        support = new PropertyChangeSupport(this);
    }

    public void startClient() {
        try {
            Socket socket = new Socket("localhost", 9988);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

            Thread t = new Thread(()->listenToServer(inFromServer,outToServer));
            t.setDaemon(true);
            t.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listenToServer(ObjectInputStream inFromServer,ObjectOutputStream outToServer) {
        try {
            outToServer.writeObject(new Request("Listener",null));
            while(true){
                Request response =(Request) inFromServer.readObject();
                if (response.getType().equals("MessageAdded")){
                    support.firePropertyChange("MessageAdded",null,response.getArg());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean isConnectionPossible(String username) {
        try {
            Request response = request(username, "connectionRequest");
            boolean b = (boolean) response.getArg();
            if (b){
                this.userName=username;
            }
            return b;
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
            Message tempMessage = new Message(message,userName);
            Request response = request(tempMessage,"addMessage");
            Message newMessage = (Message) response.getArg();
            support.firePropertyChange("MessageAdded",null,newMessage);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Request request(Object arg, String type) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 9988);
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
