package theUltimateChatSystemWithRMI.Client.model;

import theUltimateChatSystemWithRMI.shared.User;
import theUltimateChatSystemWithRMI.shared.utils.Subject;

public interface LoginModel extends Subject {
    boolean isConnectionPossible(String username);

    boolean addUser(String username, String password);

    boolean isLoginPossible(User user);

    User getUser();
}
