package client;

import sharerd.UpperCaseClient;
import sharerd.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements UpperCaseClient {

    private UpperCaseServer server;

    public RMIClient() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    public void startClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (UpperCaseServer) registry.lookup("Server");
        server.registerClient(this);
    }

    public String toUpperCase(String text) {

        try {
            String result =server.toUpperCase(text,this);
            return result;
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not contact server..");
        }

    }

    @Override
    public void update(String str) {
        System.out.println("BroadCasted >" + str);


    }
}
