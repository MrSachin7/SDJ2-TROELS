package theUltimateChatSystemWithRMI.Client.model;

import theUltimateChatSystemWithRMI.shared.utils.Subject;
import theUltimateChatSystemWithRMI.shared.User;

public interface LoginModel extends Subject {
    boolean isConnectionPossible(String username);

    boolean addUser(String username, String password);

    boolean isLoginPossible(User user);

    User getUser();
}
