package theUltimateChatSystemWithRMI.Server.networking.login;

import theUltimateChatSystemWithRMI.Server.model.LoginHandler;
import theUltimateChatSystemWithRMI.shared.User;
import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.ClientCallBack;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.LoginServer;

import java.lang.invoke.CallSite;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class LoginServerImpl implements LoginServer {
    private List<ClientCallBack> allClients;

    private LoginHandler loginHandler;

    public LoginServerImpl(LoginHandler loginHandler) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.loginHandler= loginHandler;
    }
    @Override
    public boolean addUser(User user) {
        return loginHandler.addUser(user);
    }

    @Override
    public void removeUser(User user) {
            loginHandler.removeUser(user);
    }

    @Override
    public boolean isConnectionPossible(String userName) {
        return loginHandler.isConnectionPossible(userName);
    }

    @Override
    public boolean isLoginPossible(User arg) {
        return loginHandler.isLoginPossible(arg);
    }

    @Override
    public List<String> getAllUsers() {
        return loginHandler.getAllUsers();
    }

    @Override
    public void setAllClients(List<ClientCallBack> allClients) {
        this.allClients=allClients;
    }
}
