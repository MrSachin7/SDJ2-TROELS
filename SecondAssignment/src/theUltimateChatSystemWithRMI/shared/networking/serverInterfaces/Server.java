package theUltimateChatSystemWithRMI.shared.networking.serverInterfaces;


import theUltimateChatSystemWithRMI.Client.networking.Client;
import theUltimateChatSystemWithRMI.Server.model.ChatHandler;
import theUltimateChatSystemWithRMI.Server.model.LoginHandler;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    LoginServer getLoginServer() throws RemoteException;
    ChatServer getChatServer() throws  RemoteException;
    void registerClient(Client client) throws RemoteException;
    void startServer() throws RemoteException, AlreadyBoundException;
}
