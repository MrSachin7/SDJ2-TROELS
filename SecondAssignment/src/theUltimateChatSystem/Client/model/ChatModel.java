package theUltimateChatSystem.Client.model;

import theUltimateChatSystem.Client.networking.Client;
import theUltimateChatSystem.shared.MessageList;
import theUltimateChatSystem.shared.Subject;

public interface ChatModel extends Subject {
    boolean isConnectionPossible(String username);

    void sendMessage(String message);
    Client getClient();
}
