package temperature.external;

import temperature.mediator.TemperatureModel;
import temperature.view.TemperatureViewController;

public class Thermometer implements Runnable {
    private String id;
    private double t;
    private int d;
    private TemperatureModel temperatureModel;
    private TemperatureViewController temperatureViewController;

    public Thermometer(String id, double t, TemperatureModel temperatureModel ,int d) {
        this.id = id;
        this.t = t;
        this.d=d;
        this.temperatureModel=temperatureModel;
        this.temperatureViewController=new TemperatureViewController();
    }

    private double temperature(double t, int p, int d, double t0, int s) {

        double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
        double heaterTerm = 0;
        if (p > 0) {
            double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
            heaterTerm = 30 * s * Math.abs(tMax - t) / den;
        }
        double outDoorTerm = (t - t0) * s / 250.0;
        t = Math.min(Math.max(t - outDoorTerm + heaterTerm, t0), tMax);

        return t;
    }

    @Override
    public void run() {
        while (true) {

            try {
              t=  temperature(t, 0, 1, 0, 6);
              temperatureModel.addTemperature(id,t);
                System.out.println("Temperature :" + t + " ID : " + id);


                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
