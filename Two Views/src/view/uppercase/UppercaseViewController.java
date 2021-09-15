package view.uppercase;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.text.View;
import java.io.IOException;

public class UppercaseViewController
{
  @FXML
  private Label errorLabel;
  @FXML
  private TextField requestField;
  @FXML
  private TextField replyField;


  private UppercaseViewModel viewModel;

  public void init(UppercaseViewModel uppercaseViewModel) {
    replyField.setDisable(true);
    this.viewModel = uppercaseViewModel;
    errorLabel.textProperty().bind(viewModel.errorProperty());
    requestField.textProperty().bindBidirectional(viewModel.requestProperty());
    replyField.textProperty().bind(viewModel.replyProperty());
  }

  @FXML
  private void onSubmitButton(ActionEvent actionEvent) {
    viewModel.convert();
  }

  @FXML
  private void onShow(ViewHandler viewHandler) throws IOException {
    viewHandler.openLogView();
    viewModel.clear();
  }
}

