package rmiuppercase.client.views.uppercase;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rmiuppercase.client.core.ViewHandler;
import rmiuppercase.client.core.ViewModelFactory;
import rmiuppercase.client.views.ViewController;

public class UppercaseViewController implements ViewController {
    @FXML
    private Label errorLabel;
    @FXML
    private TextField requestField;
    @FXML
    private TextField replyField;

    private UppercaseViewModel viewModel;
    private ViewHandler vh;

    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getUppercaseViewModel();
        replyField.setDisable(true);
        errorLabel.textProperty().bind(viewModel.errorProperty());
        requestField.textProperty().bindBidirectional(viewModel.requestProperty());
        replyField.textProperty().bind(viewModel.replyProperty());
    }

    @FXML
    private void onUpperCase() {
        viewModel.upperCase();
    }
    @FXML
    private void lowerCase()
    {
        viewModel.lowerCase();
    }

    // I can make this method public, or do like above, make it private and mark it @FXML.
    // The result is the same
    public void onLogButton() {
        vh.openLog();
    }
}

