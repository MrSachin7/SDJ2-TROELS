package theUltimateChatSystemWithRMI.Client.model;

import theUltimateChatSystemWithRMI.shared.Message;
import theUltimateChatSystemWithRMI.shared.PrivateMessage;
import theUltimateChatSystemWithRMI.shared.utils.Subject;

import java.util.List;

public interface ChatModel extends Subject {
    void sendMessage(Message message);
    List<Message> getMessages();

    List<String> getUsernames();

    void sendPrivateMessage(PrivateMessage privateMessage);
    boolean doesPrivateMessageExists(String username1, String username2);

    List<Message> getUsersMessage(String userName1, String username2);
}
