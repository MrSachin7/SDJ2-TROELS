package client.core;

import client.view.uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  private UppercaseViewModel uppercaseVM;
  private ModelFactory mf;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public UppercaseViewModel getUppercaseViewModel()
  {
    if (uppercaseVM == null)
    {
      uppercaseVM = new UppercaseViewModel(mf.getTextConverter());
    }
    return uppercaseVM;
  }
}
