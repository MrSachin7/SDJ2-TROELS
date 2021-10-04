package datavisualizerwithobserver.SERVER.networking;

import datavisualizerwithobserver.SERVER.model.DataRandomizer;
import datavisualizerwithobserver.SERVER.model.DataRandomizerManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private DataRandomizer dataRandomizer;

    public SocketServer(DataRandomizer dataRandomizer){
        this.dataRandomizer=dataRandomizer;
    }

    public void startServer()
    {
        try {
            ServerSocket welcomeSocket = new ServerSocket(3100);
            System.out.println("Server has been started");

            while (true){
                System.out.println("Waiting for client....");
                Socket socket = welcomeSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress()+ "  identified");
                new Thread(new SocketHandler(socket,dataRandomizer)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
