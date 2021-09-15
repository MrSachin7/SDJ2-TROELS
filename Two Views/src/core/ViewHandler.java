package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.uppercase.LogViewController;
import view.uppercase.UppercaseViewController;


import java.io.IOException;

public class ViewHandler {

    private Scene uppercaseScene;
    private Scene logViewScene;
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() throws IOException {
        stage = new Stage();
        openToUpperCase();

    }



    public void openToUpperCase() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Stage localStage = new Stage();

        loader.setLocation(getClass().getResource("../view/uppercase/UppercaseView.fxml"));
        Parent root = loader.load();
        UppercaseViewController ctrl = loader.getController();
        ctrl.init(vmf.getUppercaseViewModel());
        localStage.setTitle("Text converter");
        logViewScene = new Scene(root);
        localStage.setScene(logViewScene);
localStage.show();
    }

    public void openLogView() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Stage localStage = new Stage();
        loader.setLocation(getClass().getResource("../view/uppercase/LogView.fxml"));
        Parent root = loader.load();
        LogViewController ctrl = loader.getController();
        ctrl.init(vmf.getLogVM());
        localStage.setTitle("Log Views");
        uppercaseScene = new Scene(root);
        localStage.setScene(uppercaseScene);
        localStage.show();
    }
}
