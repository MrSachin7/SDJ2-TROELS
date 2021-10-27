package server;

import sharerd.UpperCaseClient;
import sharerd.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements UpperCaseServer {

    public ServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0)

    ;}


    @Override
    public String toUpperCase(String str, UpperCaseClient client) throws RemoteException {
        String result =str.toUpperCase();

        // lets say we have a heavy calculation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
          //  e.printStackTrace();
        }
        client.uppercaseResult(result);
        return result;
    }
}
