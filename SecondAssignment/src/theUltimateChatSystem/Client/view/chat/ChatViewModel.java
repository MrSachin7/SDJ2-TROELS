package theUltimateChatSystem.Client.view.chat;


import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import theUltimateChatSystem.Client.core.ModelFactory;
import theUltimateChatSystem.shared.Message;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ChatViewModel {
    private ModelFactory modelFactory;
    private ObservableList<Message> messages;
    private StringProperty message;
    private ObservableList<String> userList;


    public ChatViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        modelFactory.getChatModel().addListener("MessageAdded", this::messageAdded);
        modelFactory.getChatModel().addListener("userNameAdded",this::userAdded);
        modelFactory.getChatModel().getClient().addListener("userRemoved",this::userRemoved);
        loadMessages();
        message= new SimpleStringProperty();
    }

    private void messageAdded(PropertyChangeEvent event) {
        Platform.runLater(() -> {
        messages.add((Message) event.getNewValue());
    });

    }

    void loadMessages() {
        List<Message> messageList = modelFactory.getChatModel().getMessages();
        messages = FXCollections.observableArrayList(messageList);
    }
    void loadUserList(){
        Platform.runLater(()->{
            List<String> users= modelFactory.getChatModel().getUserList();
            userList=FXCollections.observableArrayList(users);
        });
    }

    public StringProperty getMessage() {
        return message;
    }

    public void sendMessage(String text) {
        modelFactory.getChatModel().sendMessage(text);
    }
    private void userAdded(PropertyChangeEvent event){
        Platform.runLater(()->{
            userList.add((String) event.getNewValue());
        });
    }
    private void userRemoved(PropertyChangeEvent event){
        Platform.runLater(()->{
            userList.remove((String) event.getNewValue());
        });
    }

    public ObservableList<Message> getMessages() {
        return messages;
    }

    public ObservableList<String> getUserList() {
        return userList;
    }
}
