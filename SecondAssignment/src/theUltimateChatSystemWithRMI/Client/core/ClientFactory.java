package theUltimateChatSystemWithRMI.Client.core;

import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.Client;

public class ClientFactory {
    private Client client;

    public Client getClient() {
        if (client == null) {
          //  client = new ClientSocket();
        }

        return client;
    }

}
