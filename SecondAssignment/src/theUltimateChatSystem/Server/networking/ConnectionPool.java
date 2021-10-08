package theUltimateChatSystem.Server.networking;

import theUltimateChatSystem.shared.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private List<ServerHandler> connections = new ArrayList<>();

    public void addConnection(ServerHandler serverHandler) {
        connections.add(serverHandler);
    }

    public void broadcastToAll(Message message) {
        for (ServerHandler socketH : connections
        ) {

            socketH.sendMessageToClient(message);
        }
    }



    public void broadCastToSelected(String userName, Message message) {
        for (ServerHandler socketH : connections
        ) {
            if (socketH.getUserName().equals(userName)) {
                socketH.sendMessageToClient(message);
            }

        }
    }

    public void broadCastUsername(String userName) {
        for (ServerHandler socketH : connections
        ) {
            socketH.sendUsersToClient(userName);

        }
    }
    public void broadcastUserDisconnected(String username) {
        for (ServerHandler socketH : connections
        ) {
            socketH.sendRemovedUserToClient(username);

        }
    }

    public int size() {
        return connections.size();
    }
}
