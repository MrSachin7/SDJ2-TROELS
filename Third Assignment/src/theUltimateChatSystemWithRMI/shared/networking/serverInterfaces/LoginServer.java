package theUltimateChatSystemWithRMI.shared.networking.serverInterfaces;

import theUltimateChatSystemWithRMI.shared.User;
import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.ClientCallBack;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LoginServer extends Remote, Serializable {
    boolean addUser(User user) throws RemoteException;

    boolean isConnectionPossible(String userName)throws RemoteException  ;

    boolean isLoginPossible(User arg) throws RemoteException ;

    List<String> getAllUsers() throws RemoteException;

    void setAllClients(List<ClientCallBack> allClients) throws RemoteException;
}
