package core;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class ViewHandler
{
  @FXML private Scene uppercaseScene;
  @FXML private Stage stage;

 /* public ViewHandler(ViewModelFactory vmf)
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
