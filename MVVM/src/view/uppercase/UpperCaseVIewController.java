package view.uppercase;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpperCaseVIewController
{
  @FXML private TextField requestField;
  @FXML private TextField replyField;
  @FXML private Label errorLabel;
  private UppercaseViewModel viewModel;

  public UpperCaseVIewController()
  {

  }

  @FXML private void onSubmitButton(ActionEvent actionEvent)
  {
    viewModel.convert();
  }

  public void init(UppercaseViewModel uppercaseViewModel)
  {

    this.viewModel = uppercaseViewModel;
    errorLabel.textProperty().bind(viewModel.errorProperty());
    requestField.textProperty().bindBidirectional(viewModel.requestProperty());
    replyField.textProperty().bind(viewModel.replyProperty());
  }
}
