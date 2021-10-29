package client;

import sharerd.LowerCaseServer;
import sharerd.Server;
import sharerd.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    private Server server;
    private UpperCaseServer upperCaseServer;
    private LowerCaseServer lowerCaseServer;

    public RMIClient() {
    }

    public void startClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (Server) registry.lookup("Server");
        this.upperCaseServer = server.getUpperCaseServer();
        this.lowerCaseServer = server.getLowerCaseServer();
    }

    public String toUpperCase(String text) {

        try {
            return upperCaseServer.toUpperCase(text);

        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not contact server..");
        }

    }

    public String toLowerCase(String text) {

        try {
            return lowerCaseServer.toLowerCase(text);

        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not contact server..");
        }

    }
}
