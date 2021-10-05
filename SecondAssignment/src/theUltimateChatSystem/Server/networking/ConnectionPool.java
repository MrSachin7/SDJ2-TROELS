package theUltimateChatSystem.Server.networking;

import theUltimateChatSystem.shared.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private List<SocketHandler> connections = new ArrayList<>();

    public void addConnection(SocketHandler socketHandler) {
        connections.add(socketHandler);
    }

    public void broadcastToAll(Message message) {
        for (SocketHandler socketH : connections
        ) {
            socketH.sendMessageToClient(message);

        }
    }

    public void broadCastToSelected(String userName, Message message) {
        for (SocketHandler socketH : connections
        ) {
            if (socketH.getUserName().equals(userName)){
                socketH.sendMessageToClient(message);
            }

        }
    }
}
