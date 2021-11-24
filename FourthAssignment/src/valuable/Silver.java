package valuable;

public class Silver implements Valuable {
    private String name;
    private double value;

    public Silver(){
        this.name = "Silver";
        this.value=20;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }
}
