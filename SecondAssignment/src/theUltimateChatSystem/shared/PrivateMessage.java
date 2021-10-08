package theUltimateChatSystem.shared;

import java.io.Serializable;

public class PrivateMessage implements Serializable {
    private String username1;
    private String username2;
    private String messageBody;
    private MessageList messageList;

    public PrivateMessage(String username1, String username2) {
        this.username1 = username1;
        this.username2 = username2;
        this.messageBody=messageBody;
        messageList = new MessageList();
    }

    public void addMessage(Message message) {
        messageList.addMessage(message);
    }

    public MessageList getMessageList() {
        return messageList;
    }

    public String getUsername2() {
        return username2;
    }

    public String getUsername1() {
        return username1;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public boolean equals(Object obj){
        if (!(obj instanceof PrivateMessage)){
            return false;
        }
        PrivateMessage temp = (PrivateMessage) obj;
        if (temp.getUsername1().equals(username1) || temp.getUsername1().equals(username2)){
            if (temp.getUsername2().equals(username1) || temp.getUsername2().equals(username2)){
                return true;
            }
        }
        return false;
    }


}
