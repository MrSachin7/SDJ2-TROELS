package theUltimateChatSystem.Client.view.loginAsGuest;

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
        this.viewModel = vmf.getUserNameViewModel();
        this.viewHandler =vh;
        serverMessage.textProperty().bind(viewModel.getServerMessage());
        statusLabel.textProperty().bind(viewModel.getStatus());
    }

    @FXML
    private void onConnect() {
        if (viewModel.onConnect(username.getText())) {
            viewHandler.openChat();
        }

    }


}
