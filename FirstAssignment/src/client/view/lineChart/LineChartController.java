package client.view.lineChart;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;


public class LineChartController {
    @FXML
    LineChart<String, Number> lineChart;

    private XYChart.Series<String, Number> series1, series2, series3;
    private ViewHandler viewHandler;


    public void init(LineChartViewModel lineChartViewModel, ViewHandler viewHandler) {
        series1 = new XYChart.Series<>();
        series1.setName("Outdoor Temp(t0)");
        series1.setData(lineChartViewModel.getList3());
        series2 = new XYChart.Series<>();
        series2.setName("Indoor Temp(t1)");
        series2.setData(lineChartViewModel.getList1());
        series3 = new XYChart.Series<>();
        series3.setName("Indoor temp(t2)");
        series3.setData(lineChartViewModel.getList2());
        this.viewHandler=viewHandler;
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
        lineChart.getData().add(series3);

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
