package client.core;


import client.view.barchart.BarChartViewModel;
import client.view.piechart.PieChartViewModel;
import client.view.textpresentation.TextViewModel;

public class ViewModelFactory {

    private PieChartViewModel pieChartViewModel;
    private BarChartViewModel barChartViewModel;
    private TextViewModel textViewModel;

    public ViewModelFactory(ModelFactory mf) {
        pieChartViewModel = new PieChartViewModel(mf.getModel());
        barChartViewModel = new BarChartViewModel(mf.getModel());
        textViewModel = new TextViewModel(mf.getModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }

    public BarChartViewModel getBarChartViewModel() {
        return barChartViewModel;
    }

    public TextViewModel getTextViewModel() {
        return textViewModel;
    }
}
