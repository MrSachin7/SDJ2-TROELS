package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UpperCaseServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket welcomeSocket = new ServerSocket(2002);
        System.out.println("Server started...");
        Socket client = welcomeSocket.accept();
        System.out.println(client.getInetAddress().getHostAddress() + " identified");

        ObjectOutputStream outToClient = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream inFromClient = new ObjectInputStream(client.getInputStream());

        try {

            while (true) {
                outToClient.writeObject("Enter the text to get the uppercase....|exit| to exit");
                String received = (String) inFromClient.readObject();
                if (received.equalsIgnoreCase("exit")) {
                    break;
                }
                outToClient.writeObject(received.toUpperCase());
            }
            client.close();

        } catch (EOFException ignored) {

        }
    }
}
