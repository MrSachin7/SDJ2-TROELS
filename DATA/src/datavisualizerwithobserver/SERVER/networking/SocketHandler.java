package datavisualizerwithobserver.SERVER.networking;

import datavisualizerwithobserver.SERVER.model.DataRandomizer;
import datavisualizerwithobserver.SERVER.model.DataRandomizerManager;
import shared.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable {


    private Socket socket;
    private DataRandomizer dataRandomizer;

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromCLient;

    public SocketHandler(Socket socket,DataRandomizer dataRandomizer)
    {
        this.socket=socket;
        this.dataRandomizer=dataRandomizer;

        try {
            outToClient= new ObjectOutputStream(socket.getOutputStream());
            inFromCLient= new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Request request = (Request) inFromCLient.readObject();
            if (request.getType().equals("update")){
                double[] doubles = dataRandomizer.update();
                outToClient.writeObject(new Request("update",doubles));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
