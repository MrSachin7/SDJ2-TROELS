package valuable;

public class WasteCan implements Valuable{
    @Override
    public String getName() {
        return "Waste Can";
    }

    @Override
    public double getValue() {
        return 0;
    }
}
