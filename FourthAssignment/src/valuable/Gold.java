package valuable;

public class Gold implements Valuable{
    private String name;
    private double value;

    public Gold() {
        this.name="Gold";
        this.value = 55;
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
