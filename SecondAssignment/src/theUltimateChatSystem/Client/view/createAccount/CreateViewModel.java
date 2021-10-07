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

    public boolean onSignup(String username, String password, String confirm) {
        if (username.equals("") || username == null) {
            error.set("Username cannot be empty");
        } else if (!(password.equals(confirm))) {
            error.set("Password and confirm password do not match");
            return false;
        } else if (modelFactory.getLoginModel().isConnectionPossible(username) == false) {
            error.set("Username unavailable, Try another...");
            return false;
        } else {
            if (modelFactory.getLoginModel().addUser(username, password)) {
                error.set("Account created , go back to login....");
                return true;
            }
        }

        return false;
    }


}
