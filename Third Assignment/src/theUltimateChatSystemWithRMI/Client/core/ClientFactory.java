package theUltimateChatSystemWithRMI.Client.core;

import theUltimateChatSystemWithRMI.Client.networking.Client;
import theUltimateChatSystemWithRMI.Client.networking.ClientImplRMI;

public class ClientFactory {
    private Client client;

    public Client getClient()  {
        if (client == null) {
          client= new ClientImplRMI();
        }

        return client;
    }

}
