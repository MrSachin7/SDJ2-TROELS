package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.add.AddTaskViewController;
import view.all.AllTasksViewController;
import view.remove.NextTaskViewController;

import java.io.IOException;

public class ViewHandler {
    private Stage stage;
    private Scene addTaskViewScene;
    private Scene nextTaskViewScene;
    private Scene allTasksViewScene;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        this.stage = stage;
    }

    public void start() {
        openAllTasksView();


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

        stage.show();
    }

    public void openAddTaskView() {
        FXMLLoader loader = new FXMLLoader();
        if (addTaskViewScene == null) {
            Parent root = getRootByPath("../view/add/AddTaskView.fxml", loader);
            AddTaskViewController controller = loader.getController();
            controller.init(viewModelFactory.getAddTaskViewModel(), this);
            addTaskViewScene = new Scene(root);
        }
        stage.setTitle("Add tasks");
        stage.setScene(addTaskViewScene);
        stage.show();


    }

    public void openGetNextTaskView() {
        FXMLLoader loader = new FXMLLoader();
        if (nextTaskViewScene==null)
        {
            Parent root = getRootByPath("../view/remove/NextTaskView.fxml",loader);
            NextTaskViewController controller = loader.getController();
            controller.init(viewModelFactory.getNextTaskViewModel(),this);
            nextTaskViewScene = new Scene(root);
        }
        stage.setTitle("Next Task");
        stage.setScene(nextTaskViewScene);
        stage.show();

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
