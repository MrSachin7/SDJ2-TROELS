package client.view.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class LoginController implements ViewController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label errorLabel;

    private LoginViewModel viewModel;
    private ViewHandler viewHandler;

    @Override
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
    private void onLoginAsGuest(ActionEvent event) {
        viewHandler.openLoginAsGuest();
    }

    @FXML
    private void onLogin(ActionEvent event) {
        if (viewModel.onLogin(username.getText(), password.getText())) {
            viewHandler.openChat();
        }
    }



}
