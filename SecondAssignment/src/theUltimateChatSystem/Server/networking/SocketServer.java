package theUltimateChatSystem.Server.networking;

import theUltimateChatSystem.Server.model.Model;
import theUltimateChatSystem.Server.model.ModelImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private Model model;


    public SocketServer(Model model) {
        this.model = model;

    }

    public void startServer() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(9009);
            System.out.println("Server started....");
            ConnectionPool cp = new ConnectionPool();
            while (true) {
                System.out.println("Waiting for clients.....");
                Socket socket = welcomeSocket.accept();
              //  System.out.println(socket.getInetAddress().getHostAddress() + "  identified");
                ServerHandler serverHandler = new ServerHandler(socket, model,cp);
             //   System.out.println("A new server handler is created");
                cp.addConnection(serverHandler);
                System.out.println(cp.size());
               Thread t = new Thread(serverHandler);
               t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
