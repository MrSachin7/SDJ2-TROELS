package theUltimateChatSystem.Client.networking;

import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.PrivateMessage;
import theUltimateChatSystem.shared.Subject;
import theUltimateChatSystem.shared.User;

import java.util.List;

public interface Client extends Subject {
    boolean isConnectionPossible(String username);

    void sendMessage(Message message);
    void startListeningToServer(User user);
    List<Message> getMessages();

    List<String> getUserList();

    boolean addUser(User user);

    boolean isLoginPossible(User user);

    void sendPrivateMessage(PrivateMessage privateMessage);

    boolean doesPrivateMessageExists(String username1, String username2);
}
