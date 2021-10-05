package theUltimateChatSystem.Client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import theUltimateChatSystem.Client.view.ViewController;

import java.io.IOException;

public class ViewHandler {
    private Scene loginScene;
    private Scene chatScene;
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf=vmf;
    }

    public void start()
    {
        stage= new Stage();
        openLogin();
    }


    public void openLogin() {
        if (loginScene == null) {
            try {
                Parent root = loadFXML("../view/username/username.fxml");
                stage.setTitle("Username");
                loginScene = new Scene(root);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(loginScene);
        stage.show();
    }

    public void openChat(){
        if (chatScene==null){
            try {
                Parent root = loadFXML("../view/chat/Chat.fxml");
                stage.setTitle("Chat");
                chatScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(chatScene);
            stage.show();

        }
    }

    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        ViewController ctrl = loader.getController();
        ctrl.init(this, vmf);
        return root;
    }
}