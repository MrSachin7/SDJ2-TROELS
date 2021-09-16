package temperature.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import temperature.mediator.Listener;
import temperature.mediator.TemperatureModel;
import temperature.model.Temperature;

public class TemperatureViewController implements Listener
{
   @FXML private Label outputLabel;
   @FXML private TextField filterField;
   @FXML private Label filterLabel;

   private ViewHandler viewHandler;
   private TemperatureModel model;
   private Region root;
   private String thermometerId;

   public TemperatureViewController()
   {
   }

   public void init(ViewHandler viewHandler, TemperatureModel model, Region root)
   {
      this.viewHandler = viewHandler;
      this.model = model;
      this.root = root;
      thermometerId = null;
   }

   public void reset()
   {
      // empty
   }

   public Region getRoot()
   {
      return root;
   }

   @FXML private void updateButtonPressed()
   {
      Temperature t = model.getLastInsertedTemperature(thermometerId);
      if (t != null)
      {
         model.addListener(this);
         outputLabel.setText(t.toString());

      }
      else
      {
         model.removeListener(this);
         outputLabel.setText("No data");
      }

   }

   @FXML private void onFilter()
   {
	  if(filterField.getText() == null) return; 
      String oldValue = filterLabel.getText();
      if (oldValue.equals("All"))
      {
         oldValue = null;
      }
      thermometerId = filterField.getText();
      if (thermometerId.isEmpty())
      {
         thermometerId = null;
         filterLabel.setText("All");
         model.removeListener(this);
      }
      else
      {
         filterLabel.setText(thermometerId);

      }
      filterField.setText(null);
      updateButtonPressed();
   }

   @Override
   public void update(Object arg) {
      Platform.runLater(()-> {
         outputLabel.setText((String) arg);
      });
   }
}
