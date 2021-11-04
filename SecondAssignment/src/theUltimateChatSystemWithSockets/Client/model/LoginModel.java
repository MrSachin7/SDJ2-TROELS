package theUltimateChatSystemWithSockets.Client.model;

import theUltimateChatSystemWithSockets.shared.User;
import theUltimateChatSystemWithSockets.shared.utils.Subject;

public interface LoginModel extends Subject {
    boolean isConnectionPossible(String username);

    boolean addUser(String username, String password);

    boolean isLoginPossible(User user);

    User getUser();
}
