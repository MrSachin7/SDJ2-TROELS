package theUltimateChatSystem.Client.core;

import theUltimateChatSystem.Client.model.ChatModel;
import theUltimateChatSystem.Client.model.ChatModelImp;
import theUltimateChatSystem.Client.model.LoginModel;
import theUltimateChatSystem.Client.model.LoginModelImpl;

public class ModelFactory {
    private final ClientFactory cf;
    private ChatModel chatModel;
    private LoginModel loginModel;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public ChatModel getChatModel() {
        if (chatModel == null) {
            this.chatModel = new ChatModelImp(cf.getClient());
        }
        return chatModel;
    }

    public LoginModel getLoginModel() {
        if (loginModel == null) {
            loginModel = new LoginModelImpl(cf.getClient());
        }
        return loginModel;
    }
}

