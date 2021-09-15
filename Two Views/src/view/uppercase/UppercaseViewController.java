package view.uppercase;

import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
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
  private ViewHandler viewHandler;


  private UppercaseViewModel viewModel;

  public void init(UppercaseViewModel uppercaseViewModel) {

    viewHandler=new ViewHandler(new ViewModelFactory(new ModelFactory()));
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


  private void onShow() throws IOException {
    viewHandler.openView("Log");
    viewModel.clear();
  }
  @FXML
  private void onShowButton(ActionEvent actionEvent) throws IOException {
    onShow();
  }

}

