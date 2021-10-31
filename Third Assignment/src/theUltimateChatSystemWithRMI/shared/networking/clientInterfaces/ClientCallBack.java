package theUltimateChatSystemWithRMI.shared.networking.clientInterfaces;



import theUltimateChatSystemWithRMI.shared.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote {
    void updateGlobalChat(Message message) throws RemoteException;
    String getUsername() throws RemoteException;

    void updatePrivateChat(Message sendMessage)  throws RemoteException;

    void updateUserAdded(String username)  throws RemoteException;
}
