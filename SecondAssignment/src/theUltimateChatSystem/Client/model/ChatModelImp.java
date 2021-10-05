package theUltimateChatSystem.Client.model;

import theUltimateChatSystem.Client.networking.Client;
import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.MessageList;

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
        client.startClient();
        client.addListener("MessageAdded",this::messageAdded);
    }

    private void messageAdded(PropertyChangeEvent event) {
        Message message =(Message) event.getNewValue();
        support.firePropertyChange("MessageAdded",null,message);
    }

    @Override
    public boolean isConnectionPossible(String username) {
        return client.isConnectionPossible(username);
    }

    @Override
    public void sendMessage(String message) {
        client.sendMessage(message);
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public List<Message> getMessages() {
        return client.getMessages();
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
