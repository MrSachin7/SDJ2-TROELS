package view.lineChart;

import core.ViewHandler;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import model.temp.Temperature;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class LineChartController {
    @FXML
    LineChart<String, Number> lineChart;

    private XYChart.Series<String, Number> series1, series2, series3;
    private ViewHandler viewHandler;
    private int count1;
    private int count2, count3;


    public void init(LineChartViewModel lineChartViewModel, ViewHandler viewHandler) {
        series1 = new XYChart.Series<>();
        series1.setName("Outdoor Temp(t0)");
        series2 = new XYChart.Series<>();
        series2.setName("Indoor Temp(t1)");
        series3 = new XYChart.Series<>();
        series3.setName("Indoor temp(t2)");
        this.viewHandler=viewHandler;
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
        lineChart.getData().add(series3);
        lineChartViewModel.getModelFactory().getTemperatureModel().addPropertyChangeListener("Temperature added", this::propertyChangeIndoor);
        lineChartViewModel.getModelFactory().getTemperatureModel().addPropertyChangeListener("Outdoor Temperature added", this::propertyChangeOutdoor);
    }

    public void propertyChangeIndoor(PropertyChangeEvent evt) {

        Temperature temperature = (Temperature) evt.getNewValue();
        if (temperature.getId().equals("t1")) {

            // The if statement ensures the there are at max 10 plots in the graph...
            if (series2.getData().size() > 10) {
                series2.getData().remove(0);
            }

            Platform.runLater(() -> series2.getData().add(new XYChart.Data<>((count1++) + "", temperature.getValue())));
        } else if (temperature.getId().equals("t2")) {
            if (series3.getData().size() > 10) {
                series3.getData().remove(0);
            }
            Platform.runLater(() -> series3.getData().add(new XYChart.Data<>((count2++) + "", temperature.getValue())));
        }

    }

    public void propertyChangeOutdoor(PropertyChangeEvent evt) {
        Temperature temperature = (Temperature) evt.getNewValue();
        if (series1.getData().size() > 10) {
            series1.getData().remove(0);
        }
        Platform.runLater(() -> series1.getData().add(new XYChart.Data<>((count3++) + "", temperature.getValue())));
    }

    @FXML
    private void onBackButton(ActionEvent actionEvent)
    {
        viewHandler.openTemperaturePresenterView();
    }
    @FXML
    private void onControlHeater(ActionEvent actionEvent)
    {
        viewHandler.openControlHeaterView();
    }

}
