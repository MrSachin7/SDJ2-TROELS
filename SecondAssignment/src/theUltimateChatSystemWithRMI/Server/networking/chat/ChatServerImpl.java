package theUltimateChatSystemWithRMI.Server.networking.chat;

import theUltimateChatSystemWithRMI.Server.model.ChatHandler;
import theUltimateChatSystemWithRMI.shared.Message;
import theUltimateChatSystemWithRMI.shared.PrivateMessage;
import theUltimateChatSystemWithRMI.shared.networking.serverInterfaces.ChatServer;

import java.rmi.RemoteException;
import java.util.List;

public class ChatServerImpl implements ChatServer {

    private ChatHandler chatHandler;

    public ChatServerImpl(ChatHandler chatHandler) {
        this.chatHandler = chatHandler;
    }

    @Override
    public List<Message> getMessages() throws RemoteException {
        return chatHandler.getMessages();
    }

    @Override
    public void addMessage(Message message) throws RemoteException {
        chatHandler.addMessage(message);

    }

    @Override
    public void addPrivateMessage(PrivateMessage privateMessage) throws RemoteException {
        chatHandler.addPrivateMessage(privateMessage);

    }

    @Override
    public List<Message> getPrivateMessage(PrivateMessage arg) throws RemoteException {
        return chatHandler.getPrivateMessage(arg);
    }
}
