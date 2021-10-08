package theUltimateChatSystem.Client.view.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import theUltimateChatSystem.Client.core.ViewHandler;
import theUltimateChatSystem.Client.core.ViewModelFactory;
import theUltimateChatSystem.Client.view.ViewController;
import theUltimateChatSystem.shared.Message;

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


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.viewModel = vmf.getChatViewModel();
        selectedItem.textProperty().bind(viewModel.getSelectedItem());
        viewModel.loadMessages();
        listView.setItems(viewModel.getMessages());
        userList.setItems(viewModel.getUserList());
        //   sendMessage.textProperty().bindBidirectional(viewModel.getMessage());

    }

    @FXML
    private void onSend(ActionEvent event) {
        viewModel.sendMessage(sendMessage.getText());
        sendMessage.clear();
    }

    @FXML
    private void onSelectUser(ActionEvent event) {
        viewModel.getSelectedItem().set(userList.getSelectionModel().getSelectedItem());
    }
    @FXML
    private void onLogOut()
    {
        viewModel.logOut();
        viewHandler.openLogin();
    }
    @FXML
    private void onSendPrivateMessage(ActionEvent event){
        viewModel.sendPrivate(sendPrivate.getText());

    }


}
