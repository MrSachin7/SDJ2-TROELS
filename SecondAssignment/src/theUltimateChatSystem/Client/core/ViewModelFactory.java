package theUltimateChatSystem.Client.core;

import theUltimateChatSystem.Client.view.username.UserNameViewModel;

public class ViewModelFactory {
    public final ModelFactory mf;
    public UserNameViewModel userNameViewModel;

    public ViewModelFactory(ModelFactory mf){
        this.mf=mf;
    }

    public UserNameViewModel getUserNameViewModel() {
        if (userNameViewModel == null) {
            userNameViewModel = new UserNameViewModel(mf);
        }
        return userNameViewModel;
    }
}
