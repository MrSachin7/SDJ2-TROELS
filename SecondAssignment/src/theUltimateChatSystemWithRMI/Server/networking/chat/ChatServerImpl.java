package theUltimateChatSystemWithRMI.Server.networking.chat;

import theUltimateChatSystemWithRMI.Server.model.ChatHandler;
import theUltimateChatSystemWithRMI.shared.Message;
import theUltimateChatSystemWithRMI.shared.PrivateMessage;
import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.ClientCallBack;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.ChatServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatServerImpl implements ChatServer {


    private List<ClientCallBack> allClients;
    private ChatHandler chatHandler;

    public ChatServerImpl(ChatHandler chatHandler) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.chatHandler = chatHandler;
        allClients = new ArrayList<>();
    }

    @Override
    public List<Message> getMessages() throws RemoteException {
        return chatHandler.getMessages();
    }

    @Override
    public void addMessage(Message message) throws RemoteException {
        chatHandler.addMessage(message);
        for (ClientCallBack all : allClients
        ) {
            all.updateGlobalChat(message);

        }

    }

    @Override
    public void addPrivateMessage(PrivateMessage privateMessage) {
        chatHandler.addPrivateMessage(privateMessage);
        for (ClientCallBack clients : allClients
        ) {
            try {
                if (clients.getUsername().equals(privateMessage.getUsername1()) || clients.getUsername().equals(privateMessage.getUsername2())) {
                    clients.updatePrivateChat(privateMessage.getSendMessage());
                }
            } catch (RemoteException e) {
                try {
                    clients.updateUserRemoved(clients.getUsername());
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    @Override
    public List<Message> getPrivateMessage(PrivateMessage arg) throws RemoteException {
        return chatHandler.getPrivateMessage(arg);
    }

    @Override
    public void setAllClients(List<ClientCallBack> allClients) {
        this.allClients = allClients;
    }
}
