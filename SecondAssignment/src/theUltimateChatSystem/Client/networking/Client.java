package theUltimateChatSystem.Client.networking;

import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.Subject;
import theUltimateChatSystem.shared.User;

import java.util.List;

public interface Client extends Subject {
    boolean isConnectionPossible(String username);

    void sendMessage(String message);
    void startClient();

    List<Message> getMessages();

    List<String> getUserList();

    boolean addUser(String username, String password);

    boolean isLoginPossible(User user);
}
