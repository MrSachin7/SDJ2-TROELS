package theUltimateChatSystemWithSockets.Client;

import javafx.application.Application;
import javafx.stage.Stage;
import theUltimateChatSystemWithSockets.Client.core.ClientFactory;
import theUltimateChatSystemWithSockets.Client.core.ModelFactory;
import theUltimateChatSystemWithSockets.Client.core.ViewHandler;
import theUltimateChatSystemWithSockets.Client.core.ViewModelFactory;

public class ChatApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf= new ViewModelFactory(mf);
        ViewHandler mv = new ViewHandler(vmf);
        mv.start();
    }

    @Override
    public void stop() throws Exception {

    }
}
