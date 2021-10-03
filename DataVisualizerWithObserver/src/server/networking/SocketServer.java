package server.networking;

import server.model.DataRandomizer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private DataRandomizer dataRandomizer;
    public SocketServer(DataRandomizer dataRandomizer)
    {
        this.dataRandomizer= dataRandomizer;
    }

    public void startServer(){
        try {
            ServerSocket welcomeSocket = new ServerSocket(3100);
            while (true){
                Socket socket =welcomeSocket.accept();
                new Thread(new SocketHandler(socket,dataRandomizer)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
