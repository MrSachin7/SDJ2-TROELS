package core;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.uppercase.UpperCaseVIewController;

import java.io.IOException;

public class ViewHandler
{
  @FXML private Scene uppercaseScene;
  @FXML private Stage stage;
  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

 /* public ViewHandler(core.ViewModelFactory vmf)
  {

  } **/

  public void start()
  {
    stage = new Stage();
    openToUpperCase();
  }

  public void openToUpperCase()
  {
    if (uppercaseScene == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
            getClass().getResource("../view/uppercase/UpperCaseVIew.fxml"));
        Parent root = loader.load();

        UpperCaseVIewController ctrl = loader.getController();
        ctrl.init(vmf.getUppercaseViewModel());
        stage.setTitle("Upper Case");
        uppercaseScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }

    }
    stage.setScene(uppercaseScene);
    stage.show();
  }
}
