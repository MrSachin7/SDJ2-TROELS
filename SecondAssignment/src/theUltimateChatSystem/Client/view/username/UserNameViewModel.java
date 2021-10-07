package theUltimateChatSystem.Client.view.username;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import theUltimateChatSystem.Client.core.ModelFactory;


public class UserNameViewModel {
    private StringProperty status;
    private StringProperty serverMessage;
    private ModelFactory modelFactory;
    private StringProperty username;

    public UserNameViewModel(ModelFactory modelFactory){
        this.modelFactory=modelFactory;
        status = new SimpleStringProperty();
        serverMessage = new SimpleStringProperty();
        username= new SimpleStringProperty();

    }
    public boolean onConnect(String text)
    {
        if (text.equals("") || text.equals(null))
        {
            serverMessage.set("Username cannot be empty");
        }
        else
        {
            boolean booelanFromServer= modelFactory.getChatModel().isConnectionPossible(text); // the get doesn't work ,binding problem I guess
            if (booelanFromServer==false){
                serverMessage.set("Username is already occupied");
            }
            return booelanFromServer;
        }
        return false;

    }

    public StringProperty getServerMessage() {
        return serverMessage;
    }

    public StringProperty getStatus() {
        return status;
    }
}
