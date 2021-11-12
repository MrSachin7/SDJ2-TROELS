package rpggame;



import java.util.Random;
import java.util.Scanner;

public class RunRPG {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Character character = new Character("Troels");

        int count = 1;
        Scanner scannerIn = new Scanner(System.in);

        outerLoop:
        while (character.getHealth() > 0) {
            Monster monster = createMonster(count);
            System.out.println("\n\n");
            System.out.println("--- You encounter a wild " + monster.getName() + " ---");

            while (monster.getHealth() > 0) {
                printActions(monster);
                takeAction(character, scannerIn, monster);
                if (monster.getHealth() > 0) {
                    monsterAttacksBack(character, monster);
                    printLife(character);
                    if (character.getHealth() <= 0) {
                        break outerLoop;
                    }
                } else {
                    System.out.println("\nMonster defeated!");
                }
            }
            count++;
        }

        System.out.println("You defeated " + count + " monsters");
    }

    private static void monsterAttacksBack(Character character, Monster monster) {
        character.takeDamage(monster.getDamage());
        System.out.println(monster.getName() + " attacks back for " + monster.getDamage() + " damage");
    }

    private static void printLife(Character character) {
        System.out.println("Your health:");
        for (int i = 0; i < character.getHealth(); i++) {
            if(i % 5 == 0) System.out.print (" ");
            System.out.print("♥");
        }
        System.out.println();
    }

    private static void takeAction(Character character, Scanner in, Monster m) {
        boolean acceptedChoice = false;
        while (!acceptedChoice) {
            String s = in.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input");
                continue;
            }

            switch (choice) {
                case 1:
                    character.attack(m);
                    acceptedChoice = true;
                    break;
                case 2:
                    character.setWeapon("sword");
                    acceptedChoice = true;
                    break;
                case 3:
                    character.setWeapon("daggers");
                    acceptedChoice = true;
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
        }
    }

    private static void printActions(Monster m) {
        System.out.println();
        System.out.println("#####");
        System.out.println("Select action:");
        System.out.println("1) attack " + m.getName());
        System.out.println("2) Equip sword");
        System.out.println("3) Equip daggers");
    }

    private static Monster createMonster(int count) {
        int health = count * 3 + 10 + rand.nextInt(count);
        int damage = count * 2 + rand.nextInt(count);
        int armor = rand.nextInt(count);
        Monster m = new Monster("Ogre", health, damage, armor);
        return m;
    }
}