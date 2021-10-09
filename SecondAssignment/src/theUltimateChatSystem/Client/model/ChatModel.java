package theUltimateChatSystem.Client.model;

import theUltimateChatSystem.Client.networking.Client;
import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.MessageList;
import theUltimateChatSystem.shared.PrivateMessage;
import theUltimateChatSystem.shared.Subject;

import java.util.List;

public interface ChatModel extends Subject {
    void sendMessage(Message message);
    List<Message> getMessages();

    List<String> getUsernames();

    void sendPrivateMessage(PrivateMessage privateMessage);
    boolean doesPrivateMessageExists(String username1, String username2);

    List<Message> getUsersMessage(String userName1, String username2);
}
