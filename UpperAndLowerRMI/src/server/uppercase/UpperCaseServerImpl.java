package server.uppercase;

import sharerd.UpperCaseClient;
import sharerd.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UpperCaseServerImpl implements UpperCaseServer {

    public UpperCaseServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);


    }
    @Override
    public String toUpperCase(String str) throws RemoteException {
        return str.toUpperCase();
    }
}
