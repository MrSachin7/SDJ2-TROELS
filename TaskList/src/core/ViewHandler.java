package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.all.AllTasksViewController;

import java.io.IOException;

public class ViewHandler {
    private Stage stage;
    private Scene addTaskViewScene;
    private Scene removeTaskViewScene;
    private Scene allTasksViewScene;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        stage = new Stage();
    }

    public void start() {
        openAllTasksView();
        stage.show();

    }

    public void openAllTasksView() {
        FXMLLoader loader = new FXMLLoader();
        if (allTasksViewScene == null) {
            Parent root = getRootByPath("../view/all/AllTasksView.fxml", loader);
            AllTasksViewController controller = loader.getController();
            controller.init(viewModelFactory.getAllTasksVM(), this);
            allTasksViewScene = new Scene(root);
        }
        this.stage.setTitle("View Tasks");
        this.stage.setScene(allTasksViewScene);

    }

    public void openAddTaskView() {

    }

    public void openGetNextTaskView() {

    }

    private Parent getRootByPath(String path, FXMLLoader loader) {
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
