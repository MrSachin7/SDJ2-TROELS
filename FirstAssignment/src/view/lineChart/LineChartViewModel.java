package view.lineChart;

import core.ModelFactory;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import model.temp.Temperature;

import java.beans.PropertyChangeEvent;

public class LineChartViewModel {
    private ModelFactory modelFactory;
    private DoubleProperty t0Property, t1Property, t2Property;
    private ObservableList<XYChart.Data<String, Number>> list1, list2, list3;
    int count1, count2, count3;

    public LineChartViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        this.list1 = FXCollections.observableArrayList();
        this.list2 = FXCollections.observableArrayList();
        this.list3 = FXCollections.observableArrayList();
        t0Property = new SimpleDoubleProperty();
        t1Property = new SimpleDoubleProperty();
        t2Property = new SimpleDoubleProperty();
        modelFactory.getTemperatureModel().addPropertyChangeListener("Temperature added", this::propertyChangeIndoor);
        modelFactory.getTemperatureModel().addPropertyChangeListener("Outdoor Temperature added", this::propertyChangeOutdoor);
    }

    public ModelFactory getModelFactory() {
        return modelFactory;
    }

    public void propertyChangeIndoor(PropertyChangeEvent evt) {

        Temperature temperature = (Temperature) evt.getNewValue();
        if (temperature.getId().equals("t1")) {
            if (list1.size()>10)
            {
                list1.remove(0);
            }

            Platform.runLater(() -> list1.add(new XYChart.Data<>((count1++) + "", temperature.getValue())));
        }
        if (temperature.getId().equals("t2")) {
            if (list2.size()>10)
            {
                list2.remove(0);
            }
            Platform.runLater(() -> list2.add(new XYChart.Data<>((count2++) + "", temperature.getValue())));
        }
    }

    public void propertyChangeOutdoor(PropertyChangeEvent evt) {
        Temperature temperature = (Temperature) evt.getNewValue();
        if (list3.size()>10)
        {
            list3.remove(0);
        }
        Platform.runLater(() -> list3.add(new XYChart.Data<>((count3++) + "", temperature.getValue())));
    }

    public ObservableList<XYChart.Data<String, Number>> getList1() {
        return list1;
    }

    public ObservableList<XYChart.Data<String, Number>> getList2() {
        return list2;
    }

    public ObservableList<XYChart.Data<String, Number>> getList3() {
        return list3;
    }
}
