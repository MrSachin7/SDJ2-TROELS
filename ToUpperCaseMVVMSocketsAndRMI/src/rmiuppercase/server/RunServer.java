package rmiuppercase.server;

import rmiuppercase.server.model.TextManagerImpl;
import rmiuppercase.shared.networking.RMIServer;
import rmiuppercase.server.networking.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        RMIServer server = new RMIServerImpl(new TextManagerImpl());
        server.startServer();
    }
}
