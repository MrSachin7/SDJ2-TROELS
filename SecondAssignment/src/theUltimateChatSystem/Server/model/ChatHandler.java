package theUltimateChatSystem.Server.model;

import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.MessageList;
import theUltimateChatSystem.shared.Subject;

import java.util.List;

public interface ChatHandler extends Subject {
    List<Message> getMessages();
    void addMessage(Message message);
}
