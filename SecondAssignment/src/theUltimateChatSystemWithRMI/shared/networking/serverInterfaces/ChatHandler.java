package theUltimateChatSystemWithRMI.shared.networking.serverInterfaces;

import theUltimateChatSystemWithRMI.shared.Message;
import theUltimateChatSystemWithRMI.shared.PrivateMessage;
import theUltimateChatSystemWithRMI.shared.utils.Subject;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatHandler extends Subject, Remote {
    List<Message> getMessages() throws RemoteException;

    void addMessage(Message message) throws RemoteException;

    void addPrivateMessage(PrivateMessage privateMessage) throws RemoteException;

    List<Message> getPrivateMessage(PrivateMessage arg) throws RemoteException;
    // boolean doesPrivateMessageExists(String username1, String username2);
}
