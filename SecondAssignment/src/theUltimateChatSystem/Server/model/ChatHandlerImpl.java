package theUltimateChatSystem.Server.model;

import theUltimateChatSystem.shared.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ChatHandlerImpl implements ChatHandler {
    private List<Message> messageList;
    private PropertyChangeSupport support;


    public ChatHandlerImpl() {

        messageList = new ArrayList<>();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void addMessage(Message message) {
        messageList.add(message);
      //  support.firePropertyChange("addMessage",null,message);   // message OR messageList to send ??
    }

    @Override
    public List<Message> getMessages() {
        return messageList;
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
