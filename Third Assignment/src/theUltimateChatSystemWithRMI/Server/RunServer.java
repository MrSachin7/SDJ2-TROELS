package theUltimateChatSystemWithRMI.Server;


import theUltimateChatSystemWithRMI.Server.model.ChatHandlerImpl;
import theUltimateChatSystemWithRMI.Server.model.LoginHandler;
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

        LoginHandler loginHandler = new LoginHandlerImp();
        LoginServer loginServer = new LoginServerImpl(loginHandler);
        ChatServer chatServer = new ChatServerImpl(new ChatHandlerImpl(),loginHandler);
        Server server = new ServerImpl(loginServer,chatServer);
       server.startServer();

    }
}
