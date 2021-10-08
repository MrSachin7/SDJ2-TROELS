package theUltimateChatSystem.Client.model;

import theUltimateChatSystem.Client.networking.Client;
import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.MessageList;
import theUltimateChatSystem.shared.Subject;

import java.util.List;

public interface ChatModel extends Subject {
    void sendMessage(Message message);
    List<Message> getMessages();

    List<String> getUsernames();
}
