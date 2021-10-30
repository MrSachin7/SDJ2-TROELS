package theUltimateChatSystemWithRMI.Client.view;

import theUltimateChatSystemWithRMI.Client.core.ViewHandler;
import theUltimateChatSystemWithRMI.Client.core.ViewModelFactory;

public interface ViewController {
    void init(ViewHandler vh, ViewModelFactory vmf);
}
