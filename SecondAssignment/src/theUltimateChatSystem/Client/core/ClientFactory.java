package theUltimateChatSystem.Client.core;

import theUltimateChatSystem.Client.networking.Client;
import theUltimateChatSystem.Client.networking.ClientSocket;

public class ClientFactory {
    private Client client;

    public Client getClient() {
        if (client == null) {
            client = new ClientSocket();
        }
        return client;
    }
}
