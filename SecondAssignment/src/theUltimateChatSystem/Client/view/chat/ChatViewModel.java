package theUltimateChatSystem.Client.view.chat;


import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import theUltimateChatSystem.Client.core.ModelFactory;
import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.PrivateMessage;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ChatViewModel {
    private ModelFactory modelFactory;
    private ObservableList<Message> messages;
    //   private StringProperty message;
    private ObservableList<String> userList;
    private ObservableList<Message> privateMessages;
    private StringProperty selectedItem;


    public ChatViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        selectedItem = new SimpleStringProperty();

        privateMessages= FXCollections.observableArrayList();
        modelFactory.getChatModel().addListener("addMessage", this::messageAdded);
        modelFactory.getLoginModel().addListener("userAdded", this::userAdded);
        modelFactory.getLoginModel().addListener("userRemoved", this::userRemoved);
        modelFactory.getChatModel().addListener("addPrivateMessage",this::privateMessageAdded);
        loadMessages();
        loadUsers();

        //  message= new SimpleStringProperty();
    }

    private void privateMessageAdded(PropertyChangeEvent event) {
        Platform.runLater(()->{
            privateMessages.add((Message) event.getNewValue());
        });
    }

    private void messageAdded(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            messages.add((Message) event.getNewValue());
        });
    }

    //
//    }
//
    void loadMessages() {
        List<Message> messageList = modelFactory.getChatModel().getMessages();
        messages = FXCollections.observableArrayList(messageList);
    }

    void loadUsers() {
        List<String> users = modelFactory.getChatModel().getUsernames();
        userList = FXCollections.observableArrayList(users);
    }

    public void sendMessage(String text) {
        Message message = new Message(text, modelFactory.getLoginModel().getUser().getUserName());
        modelFactory.getChatModel().sendMessage(message);
    }

    private void userAdded(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            userList.add((String) event.getNewValue());
        });
    }

    private void userRemoved(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            userList.remove((String) event.getNewValue());
        });
    }

    public StringProperty getSelectedItem() {
        return selectedItem;
    }

    //
    public ObservableList<Message> getMessages() {
        return messages;
    }

    //
    public ObservableList<String> getUserList() {

        return userList;
    }
  //  public String


    public void logOut() {
        Platform.runLater(() -> {
            userList.remove(modelFactory.getLoginModel().getUser());
        });
    }

    public void sendPrivate(String text) {
        String username1 = modelFactory.getLoginModel().getUser().getUserName();
        String username2= selectedItem.get();
        Message message = new Message(text,username1);
       Object[] sendObject = new Object[]{username1,username2,message};
        modelFactory.getChatModel().sendPrivateMessage(sendObject);

    }
}
