package rmiuppercase.client.network;

import rmiuppercase.shared.networking.ClientCallBack;
import rmiuppercase.shared.networking.RMIServer;
import rmiuppercase.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements Client, ClientCallBack {
    private RMIServer server;
    private PropertyChangeSupport support;

    public RMIClient() {
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void startClient() {
        try {
            UnicastRemoteObject.exportObject(this,0);
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            this.server = (RMIServer) registry.lookup("UpperCaseServer");
            server.registerClient(this);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toUppercase(String str) {
        try {
            return server.toUpperCase(str);
        } catch (RemoteException e) {
            throw new RuntimeException("Counld not contact server");
        }
    }

    @Override
    public List<LogEntry> getLog() {
        try {
            return server.getLogs();
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact the server");
        }
    }


    @Override
    public String toLowerCase(String text) {
        return null;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    @Override
    public void update(LogEntry log) throws RemoteException {
        support.firePropertyChange("NewLogEntry", null, log);
    }
}
