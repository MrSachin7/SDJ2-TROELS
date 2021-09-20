import javafx.application.Application;
import javafx.stage.Stage;
import temperature.external.Thermometer;
import temperature.mediator.TemperatureModel;
import temperature.mediator.TemperatureModelManager;
import temperature.view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();
    Thermometer thermometer1 = new Thermometer("t1",10,model,5);
    Thermometer thermometer2 = new Thermometer("t2",15,model,6);
    Thread thread1 = new Thread(thermometer1);
    Thread thread2 = new Thread(thermometer2);
    thread2.setDaemon(true);
    thread2.start();
    thread1.setDaemon(true);
    thread1.start();
    // View

    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
