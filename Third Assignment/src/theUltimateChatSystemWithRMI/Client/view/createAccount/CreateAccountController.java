package theUltimateChatSystemWithRMI.Client.view.createAccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import theUltimateChatSystemWithRMI.Client.core.ViewHandler;
import theUltimateChatSystemWithRMI.Client.core.ViewModelFactory;
import theUltimateChatSystemWithRMI.Client.view.ViewController;

public class CreateAccountController implements ViewController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirm;
    @FXML
    private Label errorLabel;

    private CreateViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
        this.viewHandler = viewHandler;
        this.viewModel = vmf.getCreateViewModel();
        username.textProperty().bindBidirectional(viewModel.getUsername());
        password.textProperty().bindBidirectional(viewModel.getPassword());
        confirm.textProperty().bindBidirectional(viewModel.getConfirm());
        errorLabel.textProperty().bind(viewModel.getError());
    }

    @FXML
    private void onAlreadyAccount(ActionEvent event) {
        viewHandler.openLogin();
    }


    @FXML
    private void onSignUp() {
        viewModel.onSignup(username.getText(), password.getText(), confirm.getText());

    }

}
