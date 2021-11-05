package theUltimateChatSystemWithRMI.Client.networking;

import theUltimateChatSystemWithRMI.shared.Message;
import theUltimateChatSystemWithRMI.shared.PrivateMessage;
import theUltimateChatSystemWithRMI.shared.User;
import theUltimateChatSystemWithRMI.shared.utils.Subject;

import java.util.List;

public interface Client extends Subject {
    boolean isConnectionPossible(String username) ;

    void sendMessage(Message message) ;

    List<Message> getMessages() ;

   // String getUsername();

    List<String> getUserList()  ;

    boolean addUser(User user)  ;

    boolean isLoginPossible(User user)  ;

    void sendPrivateMessage(PrivateMessage privateMessage)  ;

    List<Message> getUsersMessage(PrivateMessage privateMessage);
    void disconnected();
}
