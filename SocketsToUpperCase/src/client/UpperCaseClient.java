package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class UpperCaseClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost",2002);
        ObjectOutputStream outToServer =new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

        Scanner keyboard = new Scanner(System.in);

        infinite :
        while (true) {
            System.out.println((String) inFromServer.readObject());
            String text = keyboard.nextLine();
            if (text.equalsIgnoreCase("exit")){
                System.out.println("Program terminated successfully");
               break infinite;
            }
            outToServer.writeObject(text);
            String response = (String) inFromServer.readObject();
            System.out.println("Uppercase : " + response);
        }
        socket.close();
        keyboard.close();
    }
}
