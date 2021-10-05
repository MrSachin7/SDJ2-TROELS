package theUltimateChatSystem.Client.core;

import theUltimateChatSystem.Client.view.chat.ChatViewModel;
import theUltimateChatSystem.Client.view.username.UserNameViewModel;

public class ViewModelFactory {
    private final ModelFactory mf;
    private UserNameViewModel userNameViewModel;
    private ChatViewModel chatViewModel;


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
}
