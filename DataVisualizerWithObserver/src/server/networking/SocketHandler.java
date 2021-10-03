package server.networking;

import server.model.DataRandomizer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable{

    private Socket socket;
    private DataRandomizer dataRandomizer;

    private ObjectOutputStream outToCLient;
    private ObjectInputStream inFromClient;

    public SocketHandler(Socket socket, DataRandomizer dataRandomizer) {
        this.socket=socket;
        this.dataRandomizer=dataRandomizer;

        try {
            outToCLient= new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}
