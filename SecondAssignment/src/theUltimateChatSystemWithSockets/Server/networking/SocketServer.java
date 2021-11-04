package theUltimateChatSystemWithSockets.Server.networking;

import theUltimateChatSystemWithSockets.Server.model.ChatHandler;
import theUltimateChatSystemWithSockets.Server.model.LoginHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private ChatHandler model;
    private LoginHandler loginHandler;


    public SocketServer(ChatHandler model, LoginHandler loginHandler) {
        this.model = model;
        this.loginHandler = loginHandler;

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
                ServerHandler serverHandler = new ServerHandler(socket, model, loginHandler, cp);
                // System.out.println("A new server handler is created");
                // cp.addConnection(serverHandler);
                System.out.println(cp.size());
                Thread t = new Thread(serverHandler);
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
