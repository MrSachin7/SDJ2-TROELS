package theUltimateChatSystemWithRMI.Client.view.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import theUltimateChatSystemWithRMI.Client.core.ViewHandler;
import theUltimateChatSystemWithRMI.Client.core.ViewModelFactory;
import theUltimateChatSystemWithRMI.Client.view.ViewController;
import theUltimateChatSystemWithRMI.shared.Message;

public class ChatController implements ViewController {

    private ViewHandler viewHandler;
    private ChatViewModel viewModel;
    @FXML
    private TextField sendMessage;
    @FXML
    private TextField selectedItem;
    @FXML
    private ListView<Message> listView;
    @FXML
    private ListView<String> userList;
    @FXML
    private TextField sendPrivate;
    @FXML private Label userError;
    @FXML
    private ListView<Message> privateMessageList;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.viewModel = vmf.getChatViewModel();
        selectedItem.textProperty().bind(viewModel.getSelectedItem());
        viewModel.loadMessages();
        viewModel.loadUsers();
        listView.setItems(viewModel.getMessages());
        userList.setItems(viewModel.getUserList());
        userError.textProperty().bind(viewModel.getUserError());
        privateMessageList.setItems(viewModel.getPrivateMessages());
        //   sendMessage.textProperty().bindBidirectional(viewModel.getMessage());

    }

    @FXML
    private void onSend() {
        viewModel.sendMessage(sendMessage.getText());
        sendMessage.clear();
    }

    @FXML
    private void onSelectUser(ActionEvent event) {
        viewModel.getSelectedItem().set(userList.getSelectionModel().getSelectedItem());
        viewModel.loadUsersMessage();
    }

    @FXML
    private void onSendPrivateMessage(ActionEvent event){
        viewModel.sendPrivate(sendPrivate.getText());

    }


}
