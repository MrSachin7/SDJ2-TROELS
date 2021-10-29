package client;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        System.setProperty("java.security.policy","all.policy");

        if (System.getSecurityManager()==null){
            System.setSecurityManager(new RMISecurityManager());
        }

        RMIClient client = new RMIClient();
        client.startClient();

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Request? > ");
            String request = keyboard.nextLine();
            System.out.println("Input >");
            String input = keyboard.nextLine();
            if (("exit").equalsIgnoreCase(input)) break;
            try {
                String result;
                if (request.equalsIgnoreCase("lowercase")) {
                    result = client.toLowerCase(input);
                } else if (request.equalsIgnoreCase("uppercase")) {
                    result = client.toUpperCase(input);
                } else result = "Please input either uppercase or lowercase in request";
                System.out.println("Result > " + result);
                client.toUpperCase(input);
            } catch (Exception e) {

                System.out.println("Error:" + e.getMessage());
            }
        }


    }
}
