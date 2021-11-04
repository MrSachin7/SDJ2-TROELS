package theUltimateChatSystemWithSockets.Client.core;

import theUltimateChatSystemWithSockets.Client.view.chat.ChatViewModel;
import theUltimateChatSystemWithSockets.Client.view.createAccount.CreateViewModel;
import theUltimateChatSystemWithSockets.Client.view.login.LoginViewModel;



public class ViewModelFactory {
    private final ModelFactory mf;
    public CreateViewModel createViewModel;

    private ChatViewModel chatViewModel;
    private LoginViewModel loginViewModel;


    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
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

    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(mf);
        }
        return loginViewModel;
    }


}
