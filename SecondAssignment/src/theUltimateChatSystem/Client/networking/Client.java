package theUltimateChatSystem.Client.networking;

import theUltimateChatSystem.shared.MessageList;
import theUltimateChatSystem.shared.Subject;

public interface Client extends Subject {
    boolean isConnectionPossible(String username);

    void sendMessage(String message);
}
