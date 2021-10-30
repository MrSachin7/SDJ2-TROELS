package theUltimateChatSystemWithRMI.Server.model;

import theUltimateChatSystemWithRMI.shared.Message;
import theUltimateChatSystemWithRMI.shared.PrivateMessage;
import theUltimateChatSystemWithRMI.shared.utils.Subject;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatHandler extends Subject, Serializable {
    List<Message> getMessages() ;

    void addMessage(Message message);

    void addPrivateMessage(PrivateMessage privateMessage);

    List<Message> getPrivateMessage(PrivateMessage arg);
    // boolean doesPrivateMessageExists(String username1, String username2);
}
