import client.core.ModelFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;

import javafx.application.Application;
import javafx.stage.Stage;
import client.model.DataModel;

import java.util.Random;

public class DatavisualizerApp extends Application {



    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler mv = new ViewHandler(vmf);
        mv.start();

        runAutoUpdate((DataModel) mf.getModel());
    }

    private void runAutoUpdate(DataModel m) {
        Thread thread = new Thread(() -> {
            Random r = new Random();
            while (true) {
                m.recalculateData();
                try {
                    Thread.sleep(r.nextInt(10000) + 5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start() ;
    }

    @Override
    public void stop() throws Exception {

    }
}
