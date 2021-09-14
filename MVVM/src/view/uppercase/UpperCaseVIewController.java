package view.uppercase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;


public class UpperCaseVIewController {
 @FXML private TextField requestField;
  @FXML private TextField replyField;
  @FXML private  Label errorLabel;
  private UppercaseViewModel viewModel;

  @FXML
  private void onSubmitButton(ActionEvent actionEvent)
  {
   viewModel.convert();
  }

 public void init(UppercaseViewModel uppercaseViewModel)
 {

 }
}
