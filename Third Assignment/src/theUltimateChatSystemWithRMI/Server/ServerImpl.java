package theUltimateChatSystemWithRMI.Server;

import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.ClientCallBack;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.ChatServer;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.LoginServer;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements Server {
   private LoginServer loginServer;
   private ChatServer chatServer;
   private List<ClientCallBack> allClients;

    public ServerImpl(LoginServer loginServer, ChatServer chatServer) throws RemoteException {
        this.loginServer = loginServer;
        this.chatServer = chatServer;
        UnicastRemoteObject.exportObject(this, 0);
        allClients = new ArrayList<>();


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
    public void registerClient(ClientCallBack client) throws RemoteException {
        allClients.add(client);
        sendClientTOLoginServer(allClients);
        sendClientTOChatServer(allClients);
        System.out.println("A client is added");

    }

    private void sendClientTOLoginServer(List<ClientCallBack> allClients) throws RemoteException {
        loginServer.setAllClients(allClients);
    }
    private void sendClientTOChatServer(List<ClientCallBack> allClients) throws RemoteException {
        chatServer.setAllClients(allClients);
    }
}
