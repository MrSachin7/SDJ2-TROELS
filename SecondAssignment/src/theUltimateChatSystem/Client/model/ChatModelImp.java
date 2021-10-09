package theUltimateChatSystem.Client.model;

import theUltimateChatSystem.Client.networking.Client;
import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.PrivateMessage;
import theUltimateChatSystem.shared.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatModelImp implements ChatModel{
    private Client client;
    private PropertyChangeSupport support;

    public ChatModelImp(Client client)
    {
        this.client=client;
        this.support=new PropertyChangeSupport(this);
        client.addListener("addMessage",this::messageAdded);
        client.addListener("userNameAdded",this::userNameAdded);
        client.addListener("addPrivateMessage",this::privateMessageAdded);
    }

    private void privateMessageAdded(PropertyChangeEvent event) {
        support.firePropertyChange("addPrivateMessage",null,event.getNewValue());
    }

    private void messageAdded(PropertyChangeEvent event) {
        Message message =(Message) event.getNewValue();
        support.firePropertyChange("addMessage",null,message);
    }
    private void userNameAdded(PropertyChangeEvent event){
        String username = (String) event.getNewValue();
        support.firePropertyChange("userNameAdded",null,username);
    }


    @Override
    public void sendMessage(Message message) {
        client.sendMessage(message);
    }



    @Override
    public List<Message> getMessages() {
        return client.getMessages();
    }

    @Override
    public List<String> getUsernames() {
        return client.getUserList();
    }

    @Override
    public void sendPrivateMessage(PrivateMessage privateMessage) {
        client.sendPrivateMessage(privateMessage);
    }

    @Override
    public boolean doesPrivateMessageExists(String username1, String username2) {
        return client.doesPrivateMessageExists(username1,username2);
    }


    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

        support.removePropertyChangeListener(eventName,listener);
    }

}
