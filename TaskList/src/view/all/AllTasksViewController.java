package view.all;

import core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Task;

import java.awt.event.ActionEvent;

public class AllTasksViewController {
    @FXML
    private TableView<Task> tableView;
    @FXML
    private TableColumn<String, Task> creatorColumn;
    @FXML
    private TableColumn<String, Task> descriptionColumn;
    @FXML
    private TableColumn<String, Task> dateColumn;

    private AllTasksVM allTasksVM;
    private ViewHandler viewHandler;

    public void init(AllTasksVM allTasksVM, ViewHandler viewHandler) {
        creatorColumn.setCellValueFactory(new PropertyValueFactory<>("owner"));
        descriptionColumn.setCellValueFactory( new PropertyValueFactory<>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("timeCreated"));
        tableView.setItems(allTasksVM.getTaskList());
        this.viewHandler=viewHandler;
    }

    public void onAddButton(ActionEvent evt)
    {

    }
    public void onNextTaskButton(ActionEvent evt)
    {

    }
}
