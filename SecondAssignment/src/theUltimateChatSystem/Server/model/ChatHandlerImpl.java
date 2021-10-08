package theUltimateChatSystem.Server.model;

import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.PrivateMessage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ChatHandlerImpl implements ChatHandler {
    private List<Message> messageList;
    private List<PrivateMessage> privateMessageList;
    private PropertyChangeSupport support;


    public ChatHandlerImpl() {
        privateMessageList = new ArrayList<>();
        messageList = new ArrayList<>();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void addMessage(Message message) {
        messageList.add(message);
        //  support.firePropertyChange("addMessage",null,message);   // message OR messageList to send ??
    }

    @Override
    public void addPrivateMessage(Object[] objects) {

        String username1 = (String) objects[0];
        String username2 = (String) objects[1];
        Message message = (Message) objects[2];
        //PrivateMessage temp = new PrivateMessage(us)
        if (doesPrivateMessageExists(username1, username2)) {
            for (int i = 0; i < privateMessageList.size(); i++) {

                if (privateMessageList.get(i).getUsername1().equals(username1) || privateMessageList.get(i).getUsername1().equals(username2)) {
                    if (privateMessageList.get(i).getUsername2().equals(username1) || privateMessageList.get(i).getUsername2().equals(username2)) {
                        privateMessageList.get(i).getMessageList().addMessage(message);
                        System.out.println("messasge added to the exixting ");
                    }
                }
            }
        }
        else{
            PrivateMessage temp = new PrivateMessage(username1,username2);
            temp.addMessage(message);
            privateMessageList.add(temp);
            System.out.println("Message added to new");
        }
    }


    @Override
    public boolean doesPrivateMessageExists(String username1, String username2) {
        for (int i = 0; i < privateMessageList.size(); i++) {
            String user1 = privateMessageList.get(i).getUsername1();
            String user2 = privateMessageList.get(i).getUsername2();

            if (user1.equals(username1) || user1.equals(username2)) {
                if (user2.equals(username1) || user2.equals(username2)) {
                    return true;
                }
            }

        }
        return false;
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
