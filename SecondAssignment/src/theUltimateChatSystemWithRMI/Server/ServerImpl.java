package theUltimateChatSystemWithRMI.Server;

import theUltimateChatSystemWithRMI.Client.networking.Client;
import theUltimateChatSystemWithRMI.Server.model.ChatHandler;
import theUltimateChatSystemWithRMI.Server.model.LoginHandler;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.ChatServer;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.LoginServer;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server {
   private LoginServer loginServer;
   private ChatServer chatServer;

    public ServerImpl(LoginServer loginServer, ChatServer chatServer) throws RemoteException {
        this.loginServer = loginServer;
        this.chatServer = chatServer;
        UnicastRemoteObject.exportObject(this, 0);


    }

    public void startServer() throws AlreadyBoundException, RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", this);
        System.out.println("Server started...");
    }

    @Override
    public LoginServer getLoginServer() throws RemoteException {
        return loginServer ;
    }

    @Override
    public ChatServer getChatServer() throws RemoteException {
        return chatServer;
    }

    @Override
    public void registerClient(Client client) throws RemoteException {

    }
}
