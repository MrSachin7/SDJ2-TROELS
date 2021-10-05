package theUltimateChatSystem.Client.networking;

import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.MessageList;
import theUltimateChatSystem.shared.Subject;

import java.util.List;

public interface Client extends Subject {
    boolean isConnectionPossible(String username);

    void sendMessage(String message);
    void startClient();

    List<Message> getMessages();
}
