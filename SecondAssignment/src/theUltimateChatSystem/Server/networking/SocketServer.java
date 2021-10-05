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


    public SocketServer(Model model) {
        this.model = new ModelImpl();

    }

    public void startServer() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(8848);
            System.out.println("Server started....");
            ConnectionPool cp = new ConnectionPool();
            while (true) {
                System.out.println("Waiting for clients.....");
                Socket socket = welcomeSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress() + "  identified");
                SocketHandler socketHandler = new SocketHandler(socket, model,cp);
                System.out.println(socketHandler.getUserName()+" is here...");
                cp.addConnection(socketHandler);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
