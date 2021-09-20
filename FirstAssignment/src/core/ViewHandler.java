package core;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.temperaturePresenter.TemperaturePresenterController;

import javax.swing.text.View;
import java.io.IOException;

public class ViewHandler {
    private Scene temperaturePresenterScene;
    private Stage stage = new Stage();
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage,  ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory=viewModelFactory;
        stage= new Stage();
    }
    public void start()
    {
openTemperaturePresenterView();
    }

  public void openTemperaturePresenterView()
  {
      FXMLLoader loader= new FXMLLoader();
      if (temperaturePresenterScene==null)
      {
          Parent root = getRootByPath("../view/temperaturePresenter/TemperaturePresenterView.fxml",loader);
          TemperaturePresenterController controller= loader.getController();
          controller.init(viewModelFactory.getTemperaturePresenterViewModel(), this);
          temperaturePresenterScene = new Scene(root);
      }
      stage.setTitle("Temperature Presenter");
      stage.setScene(temperaturePresenterScene);
      stage.show();

  }

    private Parent getRootByPath(String path, FXMLLoader loader) {
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
