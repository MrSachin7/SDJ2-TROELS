package solution.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable {
    private final ObjectOutputStream outToClient;
    private final ObjectInputStream inFromClient;
    private Socket socket;

    public SocketHandler(Socket socket) throws IOException {
        this.socket = socket;
        outToClient = new ObjectOutputStream(socket.getOutputStream());
        inFromClient = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            infinite:
            while (true) {
                outToClient.writeObject("Enter the text to get the uppercase....|exit| to exit");
                String received = (String) inFromClient.readObject();
                if (received.equalsIgnoreCase("exit")) {
                    break infinite;
                }
                outToClient.writeObject(received.toUpperCase());
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
