package theUltimateChatSystem.Client.model;

import theUltimateChatSystem.Client.networking.Client;

public class LoginModelImpl implements LoginModel{
    private Client client;

    public LoginModelImpl(Client client)
    {
        this.client=client;
    }
    @Override
    public boolean isConnectionPossible(String username) {
        return client.isConnectionPossible(username);
    }

    @Override
    public void addUser(String username, String password) {
        client.addUser(username,password);
    }
}
