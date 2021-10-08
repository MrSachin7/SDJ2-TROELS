package theUltimateChatSystem.Client.view.privateChat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import theUltimateChatSystem.Client.core.ViewHandler;
import theUltimateChatSystem.Client.core.ViewModelFactory;
import theUltimateChatSystem.Client.view.ViewController;
import theUltimateChatSystem.shared.Message;


public class PrivateChatController implements ViewController {

    private ViewHandler viewHandler;
    private PrivateChatViewModel viewModel;
    @FXML
    private ListView<Message> listView;
    @FXML
    private TextField sendMessage;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {

        this.viewHandler = viewHandler;
        this.viewModel=vmf.getPrivateChatViewModel();
    }
    @FXML private void onSend(ActionEvent event){

    }
    @FXML
    private void onBack(){
        viewHandler.openChat();
    }
}
