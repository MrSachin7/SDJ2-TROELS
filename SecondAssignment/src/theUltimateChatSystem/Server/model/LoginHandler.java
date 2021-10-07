package theUltimateChatSystem.Server.model;

import theUltimateChatSystem.shared.User;

public interface LoginHandler {
    void addUser(User user);
    void removeUser(User user);
    boolean isConnectionPossible(String userName);
}
