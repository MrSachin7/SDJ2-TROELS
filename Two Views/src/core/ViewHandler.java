package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.uppercase.LogViewController;
import view.uppercase.UppercaseViewController;


import java.io.IOException;

public class ViewHandler {

    private Scene scene;

    private Stage stage1 = new Stage();
    private Stage stage2 = new Stage();
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() throws IOException {
        stage1 = new Stage();
        stage2 = new Stage();
        openView("convert");

    }

    public void openView(String viewToOpen) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;


        if ("convert".equals(viewToOpen)) {
            loader.setLocation(getClass().getResource("../view/uppercase/UppercaseView.fxml"));
            root = loader.load();
            UppercaseViewController ctrl = loader.getController();
            ctrl.init(vmf.getUppercaseViewModel());
            stage1.setTitle("Text converter");
            scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();

        } else if ("Log".equals(viewToOpen)) {

            loader.setLocation(getClass().getResource("../view/uppercase/LogView.fxml"));
            root = loader.load();
            LogViewController ctrl = loader.getController();
            ctrl.init(vmf.getLogVM());
            stage2.setTitle("Log Views");
            scene = new Scene(root);
            stage2.setScene(scene);
            stage2.show();


        }
    }

    public void closeStage(String text) {
        if ("Log".equals(text)) {

            stage2.close();
        } else if ("convert".equals(text)) {
            stage1.close();
        }
    }

}





