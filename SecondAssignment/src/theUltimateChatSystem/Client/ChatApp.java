package theUltimateChatSystem.Client;

import javafx.application.Application;
import javafx.stage.Stage;
import theUltimateChatSystem.Client.core.ClientFactory;
import theUltimateChatSystem.Client.core.ModelFactory;
import theUltimateChatSystem.Client.core.ViewHandler;
import theUltimateChatSystem.Client.core.ViewModelFactory;

public class ChatApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf= new ViewModelFactory(mf);
        ViewHandler mv = new ViewHandler(vmf);
        mv.start();
    }
}
