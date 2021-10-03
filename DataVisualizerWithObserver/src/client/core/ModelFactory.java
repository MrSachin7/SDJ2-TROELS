package client.core;


import client.model.DataModel;
import client.model.Model;

public class ModelFactory {

    private Model model;
    private ClientFactory clientFactory;

    public Model getModel() {
        if(model == null) model = new DataModel(clientFactory.getClient());
        return model;
    }
}
