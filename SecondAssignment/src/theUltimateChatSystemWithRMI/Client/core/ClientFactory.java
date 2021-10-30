package theUltimateChatSystemWithRMI.Client.core;

import theUltimateChatSystemWithRMI.Client.networking.ClientImplRMI;
import theUltimateChatSystemWithRMI.Client.networking.Client;

import java.rmi.RemoteException;

public class ClientFactory {
    private Client client;

    public Client getClient()  {
        if (client == null) {
          client= new ClientImplRMI();
        }

        return client;
    }

}
