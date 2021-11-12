package rpggame;

public class Character {
    private String name;
    private String weapon;
    private int health = 30;

    public Character(String name) {
        this.name = name;
    }

    public void setWeapon(String weapon) {
        System.out.println("Changing item to " + weapon);
        this.weapon = weapon;
    }

    public void attack(Monster monster) {
        System.out.println(name + " takes careful aim");

        if ("sword".equals(weapon)) {
            useSword(monster);
        } else if ("daggers".equals(weapon)) {
            useDaggers(monster);
        } else {
            System.out.println(name + " shakes fist angrily");
        }

        if(health <= 0) {
            System.out.println("Player is dead");
        }
    }

    private void useSword(rpggame.Monster monster) {
        System.out.println(name + " attacks " + monster.getName() + " with sword");
        monster.dealDamage(10);
    }

    private void useDaggers(Monster monster) {
        System.out.println(name + " attacks " + monster.getName() + " with first dagger");
        monster.dealDamage(6);
        System.out.println(name + " attacks " + monster.getName() + " with second dagger");
        monster.dealDamage(6);
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}
