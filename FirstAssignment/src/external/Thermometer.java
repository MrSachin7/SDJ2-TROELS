package external;

public class Thermometer {
    private String id;
    private double lastMeasuredTemperature;
    private int distance;

    public Thermometer(String id, double t, int d) {
        this.id = id;
        this.lastMeasuredTemperature = t;
        this.distance =d;

    }


    private double temperature(double lastMeasuredTemperature, int heatersPower, int distance, double outdoorTemperature, int seconds) {

        double tMax = Math.min(11 * heatersPower + 10, 11 * heatersPower + 10 + outdoorTemperature);
        double heaterTerm = 0;
        if (heatersPower > 0) {
            double den = Math.max((tMax * (20 - 5 * heatersPower) * (distance + 5)), 0.1);
            heaterTerm = 30 * seconds * Math.abs(tMax - lastMeasuredTemperature) / den;
        }
        double outDoorTerm = (lastMeasuredTemperature - outdoorTemperature) * seconds / 250.0;
        lastMeasuredTemperature = Math.min(Math.max(lastMeasuredTemperature - outDoorTerm + heaterTerm, outdoorTemperature), tMax);

        return lastMeasuredTemperature;
    }

    public double externalTemperature(double lastMeasuredExternalTemp, double min, double max)
    {
        double left = lastMeasuredExternalTemp - min;
        double right = max - lastMeasuredExternalTemp;
        int sign = Math.random() * (left + right) > left ? 1 : -1;
        lastMeasuredExternalTemp += sign * Math.random();
        return lastMeasuredExternalTemp;
    }

}
