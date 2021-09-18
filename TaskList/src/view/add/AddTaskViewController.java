package view.add;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddTaskViewController {
    @FXML private TextField creatorTextField;
    @FXML private TextField descriptionTextField;
    private AddTaskViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(AddTaskViewModel viewModel, ViewHandler viewHandler)
    {
        creatorTextField.textProperty().bindBidirectional(viewModel.creatorProperty());
        descriptionTextField.textProperty().bindBidirectional(viewModel.descriptionProperty());
        this.viewHandler=viewHandler;
        this.viewModel=viewModel;
    }
    @FXML private void onAddButton(ActionEvent actionEvent)
    {
        viewModel.addNewTask();
        viewModel.clear();
    }
    @FXML private void onBackButton(ActionEvent actionEvent)
    {
        viewModel.clear();
        viewHandler.openAllTasksView();
    }
}
