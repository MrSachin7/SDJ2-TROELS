package theUltimateChatSystem.Client.model;

import theUltimateChatSystem.shared.User;

public interface LoginModel {
    boolean isConnectionPossible(String username);

    boolean addUser(String username, String password);

    boolean isLoginPossible(User user);
}
