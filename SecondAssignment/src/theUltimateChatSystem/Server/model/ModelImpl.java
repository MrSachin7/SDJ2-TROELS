package theUltimateChatSystem.Server.model;

import theUltimateChatSystem.shared.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
    private List<String> usernames;
    private List<Message> messageList;
    private PropertyChangeSupport support;
    private String username;

    public ModelImpl() {
        this.usernames = new ArrayList<>();
        messageList = new ArrayList<>();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void addUserName(String username) {
        if (isConnectionPossible(username)) {
            usernames.add(username);
           // support.firePropertyChange("userAdded",null,username);
        }
        System.out.println(usernames);
    }

    @Override
    public void removeUserName(String userName) {
        if (usernames.remove(userName)){
            support.firePropertyChange("userRemoved",null,userName);
        }
        System.out.println(usernames);

    }

    @Override
    public void addMessage(Message message) {
        messageList.add(message);
       // support.firePropertyChange("MessageAdded",null,message);   // message OR messageList to send ??
    }

    @Override
    public List<Message> getMessages() {
        return messageList;
    }

    @Override
    public synchronized void setUserName(String username) {
        this.username =username;
    }

    @Override
    public List<String> getAllUsers() {
        return usernames;
    }

    @Override
    public boolean isConnectionPossible(String userName) {
        return !usernames.contains(userName);

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
