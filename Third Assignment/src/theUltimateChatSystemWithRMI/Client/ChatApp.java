package theUltimateChatSystemWithRMI.Client;

import javafx.application.Application;
import javafx.stage.Stage;
import theUltimateChatSystemWithRMI.Client.core.ClientFactory;
import theUltimateChatSystemWithRMI.Client.core.ModelFactory;
import theUltimateChatSystemWithRMI.Client.core.ViewHandler;
import theUltimateChatSystemWithRMI.Client.core.ViewModelFactory;

public class ChatApp extends Application {

    private ClientFactory cf;
    private ModelFactory mf;
    private ViewModelFactory vmf;
    private ViewHandler mv;

    @Override
    public void start(Stage stage) throws Exception {
         cf = new ClientFactory();
         mf = new ModelFactory(cf);
         vmf= new ViewModelFactory(mf);
         mv = new ViewHandler(vmf);
        mv.start();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        cf.getClient().disconnected();
    }
}
