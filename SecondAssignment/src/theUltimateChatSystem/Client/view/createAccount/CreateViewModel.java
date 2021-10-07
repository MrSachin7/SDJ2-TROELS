package theUltimateChatSystem.Client.view.createAccount;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import theUltimateChatSystem.Client.core.ModelFactory;

public class CreateViewModel {
    private StringProperty error;
    private StringProperty username, password, confirm;
    private ModelFactory modelFactory;

    public CreateViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        error = new SimpleStringProperty();
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        confirm = new SimpleStringProperty();
    }

    public StringProperty getConfirm() {
        return confirm;
    }
    public StringProperty getUsername() {
        return username;
    }
    public StringProperty getPassword() {
        return password;
    }
    public StringProperty getError() {
        return error;
    }

    public void onSignup() {
        String username = this.username.get();
        String password = this.password.get();
        String confirm = this.password.get();
        if (!(password.equals(confirm))) {
            error.set("Password and confirm password do not match");
        }
        else if (modelFactory.getLoginModel().isConnectionPossible(username) ==false)
        {
            error.set("Username unavailable, Try another...");
        }
        else
        {
            modelFactory.getLoginModel().addUser(username,password);
        }


    }
}
