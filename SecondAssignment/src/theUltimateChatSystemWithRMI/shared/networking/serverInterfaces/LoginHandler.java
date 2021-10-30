package theUltimateChatSystemWithRMI.shared.networking.serverInterfaces;

import theUltimateChatSystemWithRMI.shared.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LoginHandler extends Remote {
    boolean addUser(User user) throws RemoteException;

    void removeUser(User user) throws RemoteException;

    boolean isConnectionPossible(String userName) throws RemoteException;

    boolean isLoginPossible(User arg) throws RemoteException;

    List<String> getAllUsers() throws RemoteException;

}
