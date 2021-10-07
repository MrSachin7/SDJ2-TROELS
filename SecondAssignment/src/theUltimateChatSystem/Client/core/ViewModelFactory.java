package theUltimateChatSystem.Client.core;

import theUltimateChatSystem.Client.view.chat.ChatViewModel;
import theUltimateChatSystem.Client.view.createAccount.CreateViewModel;
import theUltimateChatSystem.Client.view.login.LoginViewModel;
import theUltimateChatSystem.Client.view.loginAsGuest.UserNameViewModel;

public class ViewModelFactory {
    private final ModelFactory mf;
    public CreateViewModel createViewModel;
    private UserNameViewModel userNameViewModel;
    private ChatViewModel chatViewModel;
    private LoginViewModel loginViewModel;


    public ViewModelFactory(ModelFactory mf){
        this.mf=mf;
    }

    public UserNameViewModel getUserNameViewModel() {
        if (userNameViewModel == null) {
            userNameViewModel = new UserNameViewModel(mf);
        }
        return userNameViewModel;
    }

    public ChatViewModel getChatViewModel() {
        if (chatViewModel == null) {
            chatViewModel = new ChatViewModel(mf);
        }
        return chatViewModel;
    }

    public CreateViewModel getCreateViewModel() {
        if (createViewModel == null) {
            createViewModel = new CreateViewModel(mf);
        }
        return createViewModel;
    }
    public LoginViewModel getLoginViewModel()
    {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(mf);
        }
        return loginViewModel;
    }

}
