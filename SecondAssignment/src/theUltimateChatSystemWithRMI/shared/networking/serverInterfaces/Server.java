package theUltimateChatSystemWithRMI.shared.networking.serverInterfaces;


import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    LoginHandler getLoginServer() throws RemoteException;
    ChatHandler getChatHandler() throws  RemoteException;
    void registerClient(Client client) throws RemoteException;
}
