package theUltimateChatSystemWithRMI.Server;

import theUltimateChatSystemWithRMI.Server.model.ChatHandlerImpl;
import theUltimateChatSystemWithRMI.Server.model.LoginHandlerImp;
import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.Client;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.ChatHandler;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.LoginHandler;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server {

    public ServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);

    }

    @Override
    public LoginHandler getLoginServer() throws RemoteException {
        return new LoginHandlerImp();
    }

    @Override
    public ChatHandler getChatHandler() throws RemoteException {
        return new ChatHandlerImpl();
    }

    @Override
    public void registerClient(Client client) throws RemoteException {

    }
}
