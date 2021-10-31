package theUltimateChatSystemWithRMI.Client.networking;

import theUltimateChatSystemWithRMI.shared.Message;
import theUltimateChatSystemWithRMI.shared.PrivateMessage;
import theUltimateChatSystemWithRMI.shared.User;
import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.ClientCallBack;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.Server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public  class ClientImplRMI implements Client, ClientCallBack {
    private Server server;
    private PropertyChangeSupport support;
    private String username;

    public ClientImplRMI() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry(1099);
            server = (Server) registry.lookup("Server");
            support = new PropertyChangeSupport(this);
            server.registerClient(this);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean isConnectionPossible(String username) {

        try {
            return server.getLoginServer().isConnectionPossible(username);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public void sendMessage(Message message) {

        try {
            server.getChatServer().addMessage(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void startListeningToServer(User user) {
        //   chatHandler.a

    }

    @Override
    public List<Message> getMessages() {

        try {
            return server.getChatServer().getMessages();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<String> getUserList() {

        try {
            return server.getLoginServer().getAllUsers();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {

        try {
            return server.getLoginServer().addUser(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean isLoginPossible(User user) {
        try {
            if (server.getLoginServer().isLoginPossible(user)){
                this.username=user.getUserName();
                return true;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void sendPrivateMessage(PrivateMessage privateMessage) {
        try {
            server.getChatServer().addPrivateMessage(privateMessage);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }


    @Override
    public List<Message> getUsersMessage(PrivateMessage privateMessage) {
        try {
            return server.getChatServer().getPrivateMessage(privateMessage);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }


    public void updateGlobalChat(Message message) throws RemoteException {
        support.firePropertyChange("addMessage", null,message);
    }

    @Override
    public String getUsername() {
       return username;
    }

    @Override
    public void updatePrivateChat(Message sendMessage) {
        support.firePropertyChange("addPrivateMessage",null,sendMessage);
    }

    @Override
    public void updateUserAdded(String username) {
        support.firePropertyChange("userAdded",null,username);
    }


}
