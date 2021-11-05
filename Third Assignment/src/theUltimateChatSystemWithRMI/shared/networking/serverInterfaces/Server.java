package theUltimateChatSystemWithRMI.shared.networking.serverInterfaces;


import theUltimateChatSystemWithRMI.Client.networking.Client;
import theUltimateChatSystemWithRMI.Client.networking.ClientImplRMI;
import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.ClientCallBack;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    LoginServer getLoginServer() throws RemoteException;
    ChatServer getChatServer() throws  RemoteException;
    void registerClient(ClientCallBack client) throws RemoteException;
    void startServer() throws RemoteException, AlreadyBoundException;

    void isDisconnected(ClientCallBack clientImplRMI) throws RemoteException;
}
