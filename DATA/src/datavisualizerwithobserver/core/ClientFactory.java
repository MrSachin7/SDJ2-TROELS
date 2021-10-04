package datavisualizerwithobserver.core;

import datavisualizerwithobserver.network.Client;
import datavisualizerwithobserver.network.ClientSocket;

public class ClientFactory {
    private Client client;

    public Client getClient() {
        if (client == null) {
            client = new ClientSocket();
        }
        return client;
    }
}
