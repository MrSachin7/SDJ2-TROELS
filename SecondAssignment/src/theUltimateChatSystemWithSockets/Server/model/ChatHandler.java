package theUltimateChatSystemWithSockets.Server.model;

import theUltimateChatSystemWithSockets.shared.Message;
import theUltimateChatSystemWithSockets.shared.PrivateMessage;
import theUltimateChatSystemWithSockets.shared.utils.Subject;

import java.util.List;

public interface ChatHandler extends Subject {
    List<Message> getMessages();
    void addMessage(Message message);

    void addPrivateMessage(PrivateMessage privateMessage);

    List<Message> getPrivateMessage(PrivateMessage arg);
    // boolean doesPrivateMessageExists(String username1, String username2);
}
