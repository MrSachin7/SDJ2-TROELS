package theUltimateChatSystem.Server.networking;

import theUltimateChatSystem.Server.model.Model;
import theUltimateChatSystem.Server.model.ModelImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {
    private Model model;
    private List<SocketHandler> allSocketHandlers;

    public SocketServer(Model model) {
        this.model = new ModelImpl();
        allSocketHandlers = new ArrayList<>();
    }

    public void startServer() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(8848);
            while (true) {
                Socket socket = welcomeSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress() + "  identified");
                SocketHandler socketHandler = new SocketHandler(socket, model, allSocketHandlers);
                allSocketHandlers.add(socketHandler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
