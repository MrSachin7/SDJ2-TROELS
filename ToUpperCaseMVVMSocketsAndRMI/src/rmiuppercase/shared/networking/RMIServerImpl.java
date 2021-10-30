package rmiuppercase.shared.networking;

import rmiuppercase.server.model.TextManager;
import rmiuppercase.shared.transferobjects.LogEntry;

import javax.swing.plaf.synth.Region;
import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImpl implements RMIServer{

    private TextManager textManager;
    public RMIServerImpl(TextManager textManager) throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        this.textManager=textManager;

    }
    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("UpperCaseServer",this);
    }
    @Override
    public String toUpperCase(String str) throws RemoteException {
        return textManager.toUppercase(str);
    }

    @Override
    public List<LogEntry> getLogs()  {
        return textManager.getLog();
    }

    @Override
    public void registerClient(ClientCallBack client) throws RemoteException {

        PropertyChangeListener listener = null;
        PropertyChangeListener finalListener= listener;
        listener = evt -> {
            try {
                client.update((LogEntry) evt.getNewValue());
            } catch (RemoteException e) {
                textManager.removeListener("NewLogEntry",finalListener);
            }
        };
        textManager.addListener("NewLogEntry",listener);
    }
}
