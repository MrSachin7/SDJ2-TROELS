package theUltimateChatSystem.Client.model;

import theUltimateChatSystem.Client.networking.Client;
import theUltimateChatSystem.shared.User;

public class LoginModelImpl implements LoginModel{
    private Client client;

    public LoginModelImpl(Client client)
    {
        this.client=client;
        client.startClient();
    }
    @Override
    public boolean isConnectionPossible(String username) {
        return client.isConnectionPossible(username);
    }

    @Override
    public boolean addUser(String username, String password) {
       return client.addUser(username,password);
    }

    @Override
    public boolean isLoginPossible(User user) {
        return client.isLoginPossible(user);
    }
}
