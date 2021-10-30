package theUltimateChatSystemWithRMI.Client.networking;

import theUltimateChatSystemWithRMI.shared.Message;
import theUltimateChatSystemWithRMI.shared.PrivateMessage;
import theUltimateChatSystemWithRMI.shared.User;
import theUltimateChatSystemWithRMI.shared.networking.clientInterfaces.Client;

import java.beans.PropertyChangeListener;
import java.util.List;

public class ClientImplRMI implements Client {



    @Override
    public boolean isConnectionPossible(String username) {
        return false;
    }

    @Override
    public void sendMessage(Message message) {

    }

    @Override
    public void startListeningToServer(User user) {

    }

    @Override
    public List<Message> getMessages() {
        return null;
    }

    @Override
    public List<String> getUserList() {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean isLoginPossible(User user) {
        return false;
    }

    @Override
    public void sendPrivateMessage(PrivateMessage privateMessage) {

    }

    @Override
    public boolean doesPrivateMessageExists(String username1, String username2) {
        return false;
    }

    @Override
    public List<Message> getUsersMessage(PrivateMessage privateMessage) {
        return null;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
