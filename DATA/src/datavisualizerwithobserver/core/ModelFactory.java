package datavisualizerwithobserver.core;

import datavisualizerwithobserver.model.DataModel;
import datavisualizerwithobserver.model.Model;

public class ModelFactory {

    private Model model;
    private ClientFactory cf;

    public ModelFactory(ClientFactory cf){
        this.cf=cf;
    }

    public Model getModel() {
        if(model == null) model = new DataModel(cf.getClient());
        return model;
    }
}
