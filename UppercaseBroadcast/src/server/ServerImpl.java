package server;

import sharerd.UpperCaseClient;
import sharerd.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements UpperCaseServer {

    private List<UpperCaseClient> clientsForBroadcast;

    public ServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.clientsForBroadcast= new ArrayList<>();
    }


    @Override
    public String toUpperCase(String str, UpperCaseClient client) throws RemoteException {
        String result = str.toUpperCase();

        // let's say we have a heavy calculation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
            //  e.printStackTrace();
        }
        updateClients(result, client);
        return result;
    }

    @Override
    public void registerClient(UpperCaseClient clientToRegister) {
        clientsForBroadcast.add(clientToRegister);

    }

    private void updateClients(String result, UpperCaseClient dontBroadCastToMe) {
        for (UpperCaseClient client : clientsForBroadcast
        ) {
            if (client.equals(dontBroadCastToMe)) continue;
            try {
                client.update(result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
