package theUltimateChatSystemWithSockets.Client.core;

import theUltimateChatSystemWithSockets.Client.networking.Client;
import theUltimateChatSystemWithSockets.Client.networking.ClientSocket;

public class ClientFactory {
    private Client client;

    public Client getClient() {
        if (client == null) {
            client = new ClientSocket();
        }

        return client;
    }

}
