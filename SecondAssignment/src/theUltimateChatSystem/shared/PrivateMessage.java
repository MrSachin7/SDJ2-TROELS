package theUltimateChatSystem.shared;

import java.io.Serializable;

public class PrivateMessage implements Serializable {
    private String sender;
    private String receiver;
    private MessageList messageList;

    public PrivateMessage(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
        messageList = new MessageList();
    }

    private void addMessage(Message message) {
        messageList.addMessage(message);
    }

    public MessageList getMessageList() {
        return messageList;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSender() {
        return sender;
    }

}
