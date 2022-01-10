package solution.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
            try {
                ServerSocket welcomeSocket = new ServerSocket(2002);
                System.out.println("Server started..");
                while (true){
                    Socket socket = welcomeSocket.accept();
                    SocketHandler socketHandler = new SocketHandler(socket);
                    new Thread(socketHandler).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


