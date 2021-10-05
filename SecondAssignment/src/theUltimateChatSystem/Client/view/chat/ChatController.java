package theUltimateChatSystem.Client.view.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import theUltimateChatSystem.Client.core.ViewHandler;
import theUltimateChatSystem.Client.core.ViewModelFactory;
import theUltimateChatSystem.Client.view.ViewController;
import theUltimateChatSystem.shared.Message;
import theUltimateChatSystem.shared.MessageList;

public class ChatController implements ViewController {

    private ViewHandler viewHandler ;
    private ChatViewModel viewModel;
    @FXML private TextField sendMessage;
    @FXML private ListView<Message> listView;
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.viewModel=vmf.getChatViewModel();
        listView.setItems(viewModel.getMessages());

    }

    @FXML private void onSend(ActionEvent event){
        viewModel.sendMessage(sendMessage.getText());
    }


}