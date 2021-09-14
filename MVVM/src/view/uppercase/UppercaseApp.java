package view.uppercase;

import core.ViewHandler;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
  //  ViewModelFactory vf = new ViewModelFactory();
    ViewHandler vh= new ViewHandler();
    vh.start();
  }
}
