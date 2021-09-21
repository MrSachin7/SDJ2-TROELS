package external;

import core.ViewModelFactory;
import model.TemperatureModel;
import model.radidator.Radiator;

public class Thermometer implements Runnable {
    private String id;
    private double lastMeasuredIndoorTemperature;
    private double lastMeasuredOutdoorTemperature;
    private int distance;
    private Radiator radiator;
    private TemperatureModel temperatureModel;
    private ViewModelFactory viewModelFactory;

    public Thermometer(String id, double lastMeasuredIndoorTemperature, int distance, TemperatureModel temperatureModel, ViewModelFactory viewModelFactory) {
        this.id = id;
        this.lastMeasuredIndoorTemperature = lastMeasuredIndoorTemperature;
        this.distance = distance;
        radiator = new Radiator();
        this.temperatureModel = temperatureModel;
        this.viewModelFactory = viewModelFactory;

    }
    public Thermometer(String id, double lastMeasuredIndoorTemperature, TemperatureModel temperatureModel, ViewModelFactory viewModelFactory) {
        this.id = id;
        this.lastMeasuredIndoorTemperature = lastMeasuredIndoorTemperature;
        radiator = new Radiator();
        this.temperatureModel = temperatureModel;
        this.viewModelFactory = viewModelFactory;
        this.lastMeasuredOutdoorTemperature=19;
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
                if (id !="t0")
                {
                    lastMeasuredIndoorTemperature = temperature(lastMeasuredIndoorTemperature, radiator.getPower(), 1, lastMeasuredOutdoorTemperature, 6);

                    temperatureModel.addTemperature(id, lastMeasuredIndoorTemperature);
                    ;
                    System.out.println("Temperature :" + lastMeasuredIndoorTemperature + " ID : " + id);
                    viewModelFactory.getTemperaturePresenterViewModel().updateData();
                }

                if (id =="t0")
                {
                    lastMeasuredOutdoorTemperature = externalTemperature(lastMeasuredOutdoorTemperature,-20,20);
                    temperatureModel.addOutdoorTemperature(id,lastMeasuredOutdoorTemperature);
                    System.out.println("OutDoor temperature :"+ lastMeasuredOutdoorTemperature+ " ID : "+id);
                    viewModelFactory.getTemperaturePresenterViewModel().updateData();

                }


                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
