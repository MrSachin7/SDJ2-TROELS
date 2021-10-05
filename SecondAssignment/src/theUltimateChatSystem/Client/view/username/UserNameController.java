package theUltimateChatSystem.Client.view.username;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import theUltimateChatSystem.Client.core.ViewHandler;
import theUltimateChatSystem.Client.core.ViewModelFactory;
import theUltimateChatSystem.Client.view.ViewController;

public class UserNameController implements ViewController {
    @FXML
    private Label statusLabel;
    @FXML
    private Label serverMessage;
    @FXML
    private TextField username;
    private UserNameViewModel viewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewModel = viewModel;
        this.viewHandler =viewHandler;
    }

    @FXML
    private void onConnect() {
        if (viewModel.onConnect(username.getText())) {
          //  viewHandler.openChat();
        }

    }


}
