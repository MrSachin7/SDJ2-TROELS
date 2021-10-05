package theUltimateChatSystem.Server.model;

import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.MessageList;
import theUltimateChatSystem.shared.Subject;

import java.util.List;

public interface Model extends Subject {
    boolean isConnectionPossible(String userName);
    void addUserName(String userName);
    void removeUserName(String userName);
    void addMessage(Message message);
    List<Message> getMessages();
}
