package view.uppercase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;


public class UpperCaseVIewController {
 @FXML private TextField requestField;
  @FXML private TextField replyField;
  @FXML private  Label errorLabel;

  @FXML
  private void onSubmitButton(ActionEvent actionEvent)
  {
    System.out.println("Submit pressed");
  }


}
