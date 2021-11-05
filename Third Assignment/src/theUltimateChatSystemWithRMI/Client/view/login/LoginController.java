package theUltimateChatSystemWithRMI.Client.view.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import theUltimateChatSystemWithRMI.Client.core.ViewHandler;
import theUltimateChatSystemWithRMI.Client.core.ViewModelFactory;
import theUltimateChatSystemWithRMI.Client.view.ViewController;


public class LoginController implements ViewController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label errorLabel;

    private LoginViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
        this.viewHandler = viewHandler;
        this.viewModel = vmf.getLoginViewModel();
        username.textProperty().bindBidirectional(viewModel.getUsername());
        password.textProperty().bindBidirectional(viewModel.getPassword());
        errorLabel.textProperty().bind(viewModel.getError());
    }

    @FXML
    public void onCreateAccount(ActionEvent event) {
        viewHandler.openCreateAccount();
    }


    @FXML
    private void onLogin(ActionEvent event) {
        if (viewModel.onLogin(username.getText(), password.getText())) {
            viewHandler.openChat();
        }
    }


}
