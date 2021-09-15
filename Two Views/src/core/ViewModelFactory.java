package core;

import view.uppercase.UppercaseViewModel;
import view.uppercase.log.LogViewModel;

public class ViewModelFactory
{
  private UppercaseViewModel uppercaseVM;
  private ModelFactory mf;
  private LogViewModel logVM;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
    if (logVM == null) {
      logVM = new LogViewModel(mf.getTextConverter());
    }
    if (uppercaseVM == null) {
      uppercaseVM = new UppercaseViewModel(mf.getTextConverter());
    }
  }

  public UppercaseViewModel getUppercaseViewModel()
  {
    if (uppercaseVM == null)
    {
      uppercaseVM = new UppercaseViewModel(mf.getTextConverter());
    }
    return uppercaseVM;
  }

  public LogViewModel getLogVM() {
    if (logVM == null) {
      logVM = new LogViewModel(mf.getTextConverter());
    }
    return logVM;
  }
}
