package theUltimateChatSystemWithRMI.shared.networking.serverInterfaces;

import theUltimateChatSystemWithRMI.shared.Message;
import theUltimateChatSystemWithRMI.shared.PrivateMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatServer extends Remote {
    List<Message> getMessages() throws RemoteException;

    void addMessage(Message message) throws RemoteException;

    void addPrivateMessage(PrivateMessage privateMessage) throws RemoteException;

    List<Message> getPrivateMessage(PrivateMessage arg) throws RemoteException;
}
