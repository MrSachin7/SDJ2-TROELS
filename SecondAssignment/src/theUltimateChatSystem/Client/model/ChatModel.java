package theUltimateChatSystem.Client.model;

import theUltimateChatSystem.shared.Subject;

public interface ChatModel extends Subject {
    boolean isConnectionPossible(String username);
}
