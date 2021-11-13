package seaBear;

import java.util.Scanner;

public class Main {
    private static String whatIsPersonType() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Who are you ??\n" +
                "1) Adult\n" +
                "2) Children\n" +
                "3) ZooKeeper.");
        String answer = keyboard.nextLine();

        switch (answer) {
            case "1":
                return "Adult";
            case "2":
                return "Children";
            case "3":
                return "Zookeeper";
            default:
                return null;
        }
    }


    public static void main(String[] args) {
        VisitSeaBear visitSeaBear = new SeaBearGuard();
        String personType = Main.whatIsPersonType();
       visitSeaBear.pet(personType);
       visitSeaBear.view(personType);
       visitSeaBear.feed(personType);

    }

}
