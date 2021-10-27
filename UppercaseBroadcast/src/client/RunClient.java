package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIClient client = new RMIClient();
        client.startClient();

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Input >");
            String input = keyboard.nextLine();
            if (("exit").equalsIgnoreCase(input)) break;
           String result =client.toUpperCase(input);
            System.out.println("Result >"+result);
        }


    }
}
