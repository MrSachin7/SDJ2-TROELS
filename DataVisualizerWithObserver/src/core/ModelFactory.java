package core;


import model.DataModel;
import model.Model;

public class ModelFactory {

    private Model model;

    public Model getModel() {
        if(model == null) model = new DataModel();
        return model;
    }
}
