package theUltimateChatSystem.Client.view.chat;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import theUltimateChatSystem.Client.core.ModelFactory;
import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.MessageList;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class ChatViewModel {
    private ModelFactory modelFactory;
    private ObservableList<String> messages;


    public ChatViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        messages = FXCollections.observableArrayList();
        modelFactory.getChatModel().addListener("MessageAdded",this::messageAdded);
    }

    private void messageAdded(PropertyChangeEvent event) {
        Platform.runLater(()->{
            Message newMessage = (Message) event.getNewValue();
            messages.add(newMessage+"");
        });

    }

    public void sendMessage(String message) {
       modelFactory.getChatModel().sendMessage(message);
    }

    public ObservableList<String> getMessages() {
        return messages;
    }
}
