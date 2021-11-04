package theUltimateChatSystemWithSockets.Client.core;

import theUltimateChatSystemWithSockets.Client.model.ChatModel;
import theUltimateChatSystemWithSockets.Client.model.ChatModelImp;
import theUltimateChatSystemWithSockets.Client.model.LoginModel;
import theUltimateChatSystemWithSockets.Client.model.LoginModelImpl;

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

