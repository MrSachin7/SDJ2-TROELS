package sharerd;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseClient extends Remote {
    void uppercaseResult(String str) throws RemoteException;
}
