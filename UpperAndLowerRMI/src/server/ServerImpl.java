package server;

import server.lowercase.LowerCaseServerImpl;
import server.uppercase.UpperCaseServerImpl;
import sharerd.LowerCaseServer;
import sharerd.Server;
import sharerd.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server {

    public ServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);

    }


    @Override
    public UpperCaseServer getUpperCaseServer() throws RemoteException {
        return new UpperCaseServerImpl();
    }

    @Override
    public LowerCaseServer getLowerCaseServer() throws RemoteException {
        return new LowerCaseServerImpl();
    }
}
