package theUltimateChatSystem.Client.model;

import theUltimateChatSystem.shared.Subject;
import theUltimateChatSystem.shared.User;

public interface LoginModel extends Subject {
    boolean isConnectionPossible(String username);

    boolean addUser(String username, String password);

    boolean isLoginPossible(User user);

    User getUser();
}
