import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;
import model.TemperatureModel;
import model.TemperatureModelManager;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        Thermometer thermometer1 = new Thermometer("t1",10,5, modelFactory.getTemperatureModel(),viewModelFactory);
        Thermometer thermometer2 = new Thermometer("t2",15,6,modelFactory.getTemperatureModel(),viewModelFactory);
        Thread thread1 = new Thread(thermometer1);
        Thread thread2 = new Thread(thermometer2);
        thread2.setDaemon(true);
        thread2.start();
        thread1.setDaemon(true);
        thread1.start();



        ViewHandler viewHandler = new ViewHandler(stage,viewModelFactory);
        viewHandler.start();
    }
}
