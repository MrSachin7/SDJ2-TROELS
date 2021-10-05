package theUltimateChatSystem.Client.view.username;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import theUltimateChatSystem.Client.core.ModelFactory;


public class UserNameViewModel {
    private StringProperty status;
    private StringProperty serverMessage;
    private ModelFactory modelFactory;

    public UserNameViewModel(ModelFactory modelFactory){
        status = new SimpleStringProperty();
        serverMessage = new SimpleStringProperty();

    }
    public boolean onConnect(String username)
    {
       boolean booelanFromServer= modelFactory.getChatModel().isConnectionPossible(username);
       if (booelanFromServer==false){
           serverMessage.set("Username is already occupied");
       }
       return booelanFromServer;

    }
}
