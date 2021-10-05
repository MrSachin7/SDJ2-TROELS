package theUltimateChatSystem.Client.view.chat;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import theUltimateChatSystem.Client.core.ModelFactory;
import theUltimateChatSystem.shared.Message;
import java.beans.PropertyChangeEvent;
import java.util.List;

public class ChatViewModel {
    private ModelFactory modelFactory;
    private ObservableList<Message> messages;


    public ChatViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        modelFactory.getChatModel().addListener("MessageAdded", this::messageAdded);
    }

    private void messageAdded(PropertyChangeEvent event) {
        Platform.runLater(()->{
           messages.add((Message) event.getNewValue());
        });

    }

    void loadMessages() {
        List<Message> messageList = modelFactory.getChatModel().getMessages();
        messages = FXCollections.observableArrayList(messageList);
    }


    public void sendMessage(String message) {
        modelFactory.getChatModel().sendMessage(message);
    }

    public ObservableList<Message> getMessages() {
        return messages;
    }
}
