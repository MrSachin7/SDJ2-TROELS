package view.lineChart;

import com.sun.webkit.Timer;
import core.ModelFactory;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class LineChartViewModel {
    private ModelFactory modelFactory;
    private DoubleProperty t0Property,t1Property,t2Property;

    public LineChartViewModel(ModelFactory modelFactory)
    {
        this.modelFactory=modelFactory;
        t0Property= new SimpleDoubleProperty();
        t1Property=new SimpleDoubleProperty();
        t2Property= new SimpleDoubleProperty();
    }

    public ModelFactory getModelFactory() {
        return modelFactory;
    }
}
