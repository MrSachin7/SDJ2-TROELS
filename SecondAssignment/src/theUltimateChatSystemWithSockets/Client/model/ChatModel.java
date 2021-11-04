package theUltimateChatSystemWithSockets.Client.model;

import theUltimateChatSystemWithSockets.shared.Message;
import theUltimateChatSystemWithSockets.shared.PrivateMessage;
import theUltimateChatSystemWithSockets.shared.utils.Subject;

import java.util.List;

public interface ChatModel extends Subject {
    void sendMessage(Message message);
    List<Message> getMessages();

    List<String> getUsernames();

    void sendPrivateMessage(PrivateMessage privateMessage);
    boolean doesPrivateMessageExists(String username1, String username2);

    List<Message> getUsersMessage(String userName1, String username2);
}
