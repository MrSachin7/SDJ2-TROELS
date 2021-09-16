import javafx.application.Application;
import javafx.stage.Stage;
import temperature.mediator.TemperatureModel;
import temperature.mediator.TemperatureModelManager;
import temperature.model.Thermometer;
import temperature.view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModelManager model = new TemperatureModelManager();
    Thermometer thermometer1 = new Thermometer("t1",10,model);
    Thermometer thermometer2 = new Thermometer("t2",15,model);
    Thread t1 = new Thread(thermometer1);
    t1.start();
    Thread t2 = new Thread(thermometer2);
    t2.start();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
