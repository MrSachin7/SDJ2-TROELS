package rmiuppercase.shared.networking;

import rmiuppercase.shared.transferobjects.LogEntry;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote {
    String toUpperCase(String str) throws RemoteException;
    List<LogEntry> getLogs() throws RemoteException;
    void registerClient(ClientCallBack client) throws RemoteException;

    void startServer() throws RemoteException, AlreadyBoundException;
}
