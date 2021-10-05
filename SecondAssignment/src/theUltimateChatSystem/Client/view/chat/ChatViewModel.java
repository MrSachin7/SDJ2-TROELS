package theUltimateChatSystem.Client.view.chat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import theUltimateChatSystem.Client.core.ModelFactory;
import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.MessageList;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ChatViewModel {
    private ModelFactory modelFactory;
    private ObservableList<Message> messages;


    public ChatViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        messages = FXCollections.observableArrayList();
        modelFactory.getChatModel().getClient().addListener("MessageAdded",this::messageAdded);
    }

    private void messageAdded(PropertyChangeEvent event) {
        messages.add((Message) event.getNewValue());
    }

    public void sendMessage(String message) {
       modelFactory.getChatModel().sendMessage(message);
    }

    public ObservableList<Message> getMessages() {
        return messages;
    }
}
