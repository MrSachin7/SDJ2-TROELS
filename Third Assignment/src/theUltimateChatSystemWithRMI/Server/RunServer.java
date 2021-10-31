package theUltimateChatSystemWithRMI.Server;


import theUltimateChatSystemWithRMI.Server.model.ChatHandlerImpl;
import theUltimateChatSystemWithRMI.Server.model.LoginHandlerImp;
import theUltimateChatSystemWithRMI.Server.networking.chat.ChatServerImpl;
import theUltimateChatSystemWithRMI.Server.networking.login.LoginServerImpl;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.ChatServer;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.LoginServer;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;


public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        LoginServer loginServer = new LoginServerImpl(new LoginHandlerImp());
        ChatServer chatServer = new ChatServerImpl(new ChatHandlerImpl());
        Server server = new ServerImpl(loginServer,chatServer);
       server.startServer();

    }
}
