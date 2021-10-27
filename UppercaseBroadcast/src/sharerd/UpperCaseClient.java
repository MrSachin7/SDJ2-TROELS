package sharerd;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseClient extends Remote {
    void update(String str) throws RemoteException;
}
