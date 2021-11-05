package theUltimateChatSystemWithRMI.shared.networking.serverInterfaces;

import theUltimateChatSystemWithRMI.Client.networking.Client;
import theUltimateChatSystemWithRMI.Client.networking.ClientImplRMI;
import theUltimateChatSystemWithRMI.shared.Message;
import theUltimateChatSystemWithRMI.shared.PrivateMessage;
import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.ClientCallBack;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatServer extends Remote,Serializable {
    List<Message> getMessages() throws RemoteException;

    void addMessage(Message message) throws RemoteException;

    void addPrivateMessage(PrivateMessage privateMessage) throws RemoteException;

    List<Message> getPrivateMessage(PrivateMessage arg) throws RemoteException;

    void setAllClients(List<ClientCallBack> allClients) throws RemoteException;

    void isDisconnected(ClientCallBack clientImplRMI) throws RemoteException;
}
