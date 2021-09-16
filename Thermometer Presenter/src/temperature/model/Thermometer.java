package temperature.model;

import temperature.mediator.TemperatureModel;
import temperature.mediator.TemperatureModelManager;
import temperature.view.TemperatureViewController;

public class Thermometer implements Runnable {
    private String id;
    private double t;
    private TemperatureModelManager temperatureModel;


    public Thermometer(String id, double t, TemperatureModelManager temperatureModel) {
        this.id = id;
        this.t = t;
        this.temperatureModel = temperatureModel;
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

                t = temperature(t, 0, 1, 0, 6);
                temperatureModel.addTemperature(this.id, t);
                String a = ("Temperature :" + t + " ID : " + id);
                System.out.println(a);
                if (temperatureModel.getListeners().size()>0 && (temperatureModel !=null)) {
                    for (int i = 0; i < temperatureModel.getListeners().size(); i++) {
                        temperatureModel.getListeners().get(i).update(a);

                    }
                }

                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
