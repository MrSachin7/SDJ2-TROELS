package theUltimateChatSystem.Client.core;

import theUltimateChatSystem.Client.model.ChatModel;
import theUltimateChatSystem.Client.model.ChatModelImp;

public class ModelFactory {
    private final ClientFactory cf;
    private ChatModel chatModel;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public ChatModel getChatModel() {
        if (chatModel == null) {
            chatModel = new ChatModelImp();
        }
        return chatModel;
    }
}

