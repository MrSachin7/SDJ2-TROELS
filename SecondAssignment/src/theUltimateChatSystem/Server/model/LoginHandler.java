package theUltimateChatSystem.Server.model;

import theUltimateChatSystem.shared.User;

public interface LoginHandler {
    boolean addUser(User user);
    void removeUser(User user);
    boolean isConnectionPossible(String userName);

    boolean isLoginPossible(User arg);
}
