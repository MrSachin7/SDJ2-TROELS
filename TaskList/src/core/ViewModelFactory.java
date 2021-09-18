package core;

import com.sun.webkit.Timer;
import view.all.AllTasksVM;



public class ViewModelFactory {
    private ModelFactory modelFactory;
    private AllTasksVM allTasksVM;

    public ViewModelFactory(ModelFactory modelFactory)
    {
        this.modelFactory=modelFactory;
    }

    public AllTasksVM getAllTasksVM() {
        if (allTasksVM == null) {
            allTasksVM = new AllTasksVM(modelFactory.getTaskModel());
        }
        return allTasksVM;
    }
}
