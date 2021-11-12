package rpggame;

public class Monster {
    private String name;
    private int health;
    private int damage;
    private int armor;


    public Monster(String name, int health, int damage, int armor) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }

    public void dealDamage(int dmg) {
        dmg -= armor;
        health -= dmg;
        System.out.println(name + " takes " + dmg + " damage. Current health is " + health);
        System.out.println("\t"+armor + " damages was blocked by armor");
        if(health <= 0) {
            System.out.println(name + " died.");
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
}
