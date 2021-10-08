package theUltimateChatSystem.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrivateMessageList implements Serializable {

    public List<PrivateMessage> allPrivateMessages;

    public PrivateMessageList() {
        this.allPrivateMessages = new ArrayList<>();
    }

    public void addPrivateMessage(PrivateMessage privateMessage) {
        allPrivateMessages.add(privateMessage);
    }

}
