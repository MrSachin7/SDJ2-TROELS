package theUltimateChatSystemWithRMI.shared.networking.clientInterfaces;



import theUltimateChatSystemWithRMI.shared.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote {
    void updateGlobalChat(Message message) throws RemoteException;

}
