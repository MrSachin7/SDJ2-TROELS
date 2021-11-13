package seaBear;

import java.util.Scanner;

public class SeaBearGuard implements VisitSeaBear {
    private String personType;
    private VisitSeaBear visitSeaBear;

    public SeaBearGuard() {
        this.visitSeaBear = new SeaBear();

    }



    @Override
    public void view(String personType) {
        visitSeaBear.view(personType);
    }

    @Override
    public void feed(String personType) {
        if (personType.equals("ZooKeeper")) {
            visitSeaBear.view(personType);
        } else {
            System.out.println("Only zookeepers are allowed to feed the bear");
        }

    }

    @Override
    public void pet(String personType) {
        if (personType.equals("Children")) {
            visitSeaBear.pet(personType);
        }
        else
        {
            System.out.println("Only children are allowed to pet the bear");
        }
    }
}
