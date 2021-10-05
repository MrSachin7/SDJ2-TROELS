package theUltimateChatSystem.Client.model;

import theUltimateChatSystem.Client.networking.Client;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChatModelImp implements ChatModel{
    private Client client;
    private PropertyChangeSupport support;

    public ChatModelImp()
    {
        this.support=new PropertyChangeSupport(this);
    }

    @Override
    public boolean isConnectionPossible(String username) {
        return client.isConnectionPossible(username);
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
