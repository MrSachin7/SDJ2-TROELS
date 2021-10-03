package client.view.uppercase;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.IOException;

public class UppercaseViewController
{
  @FXML
  private Label errorLabel;
  @FXML
  private TextField requestField;
  @FXML
  private TextField replyField;
  private ViewHandler viewHandler;


  private UppercaseViewModel viewModel;

  public void init(UppercaseViewModel uppercaseViewModel,ViewHandler viewHandler) {

   this.viewHandler=viewHandler;
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
    private void onShowButton() throws IOException {
        viewHandler.openView("Log");
        viewModel.clear();
    }


}

