package client.model.temp;

public class Temperature {
    private String id;
    private double value;


    public Temperature(String id, double value) {
        this.id = id;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return this.id + "      " + this.value;
    }
}
