package external;

import client.core.ModelFactory;
import client.core.ViewModelFactory;

public class Thermometer implements Runnable {
    private String id;
    private double lastMeasuredIndoorTemperature1;
    private double lastMeasuredOutdoorTemperature;
    private double lastMeasuredIndoorTemperature2;
    private int distance;
    private ModelFactory modelFactory;
    private ViewModelFactory viewModelFactory;

    public Thermometer(String id, int distance, ModelFactory modelFactory, ViewModelFactory viewModelFactory) {
        this.id = id;
        this.distance = distance;
        this.modelFactory = modelFactory;
        this.viewModelFactory = viewModelFactory;
        lastMeasuredIndoorTemperature2 = 8;
        lastMeasuredIndoorTemperature1 = 9;
        lastMeasuredOutdoorTemperature = 5;
    }

    public Thermometer(String id, ModelFactory modelFactory, ViewModelFactory viewModelFactory) {
        this.id = id;
        this.modelFactory = modelFactory;
        this.viewModelFactory = viewModelFactory;
        lastMeasuredIndoorTemperature2 = 8;
        lastMeasuredIndoorTemperature1 = 9;
        lastMeasuredOutdoorTemperature = 5;
    }


    private double temperature(double lastMeasuredIndoorTemperature, int heatersPower, int distance, double outdoorTemperature, int seconds) {

        double tMax = Math.min(11 * heatersPower + 10, 11 * heatersPower + 10 + outdoorTemperature);
        double heaterTerm = 0;
        if (heatersPower > 0) {
            double den = Math.max((tMax * (20 - 5 * heatersPower) * (distance + 5)), 0.1);
            heaterTerm = 30 * seconds * Math.abs(tMax - lastMeasuredIndoorTemperature) / den;
        }
        double outDoorTerm = (lastMeasuredIndoorTemperature - outdoorTemperature) * seconds / 250.0;
        lastMeasuredIndoorTemperature = Math.min(Math.max(lastMeasuredIndoorTemperature - outDoorTerm + heaterTerm, outdoorTemperature), tMax);

        return lastMeasuredIndoorTemperature;
    }

    public double externalTemperature(double lastMeasuredExternalTemp, double min, double max) {
        double left = lastMeasuredExternalTemp - min;
        double right = max - lastMeasuredExternalTemp;
        int sign = Math.random() * (left + right) > left ? 1 : -1;
        lastMeasuredExternalTemp += sign * Math.random();
        return lastMeasuredExternalTemp;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (id.equals("t1")) {
                    lastMeasuredIndoorTemperature1 = temperature(lastMeasuredIndoorTemperature1, modelFactory.getRadiator().getPower(), this.distance, lastMeasuredOutdoorTemperature, 6);
                    modelFactory.getTemperatureModel().addTemperature(id, lastMeasuredIndoorTemperature1);
                    System.out.println("Temperature :" + lastMeasuredIndoorTemperature1 + " ID : " + id);

                }
                if (this.id.equals("t2")) {
                    lastMeasuredIndoorTemperature2 = temperature(lastMeasuredIndoorTemperature2, modelFactory.getRadiator().getPower(), this.distance, lastMeasuredOutdoorTemperature, 6);
                    modelFactory.getTemperatureModel().addTemperature(id, lastMeasuredIndoorTemperature2);
                    System.out.println("Temperature :" + lastMeasuredIndoorTemperature2 + " ID : " + id);

                } else if (id.equals("t0")) {
                    lastMeasuredOutdoorTemperature = externalTemperature(lastMeasuredOutdoorTemperature, -20, 20);
                    modelFactory.getTemperatureModel().addOutdoorTemperature(id, lastMeasuredOutdoorTemperature);
                    System.out.println("OutDoor temperature :" + lastMeasuredOutdoorTemperature + " ID : " + id);
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
