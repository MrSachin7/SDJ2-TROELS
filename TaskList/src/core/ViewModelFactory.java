package core;

import com.sun.webkit.Timer;
import view.add.AddTaskViewModel;
import view.all.AllTasksVM;


public class ViewModelFactory {
    private ModelFactory modelFactory;
    private AllTasksVM allTasksVM;
    private AddTaskViewModel addTaskViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;

    }

    public AllTasksVM getAllTasksVM() {
        if (allTasksVM == null) {
            allTasksVM = new AllTasksVM(modelFactory.getTaskModel());
        }
        return allTasksVM;
    }
    public AddTaskViewModel getAddTaskViewModel()
    {
        if (addTaskViewModel == null) {
            addTaskViewModel = new AddTaskViewModel(modelFactory.getTaskModel());
        }
        return addTaskViewModel;
    }
}
