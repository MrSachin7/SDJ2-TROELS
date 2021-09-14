package core;

import view.uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  private UppercaseViewModel uppercaseVM;

  public ViewModelFactory()
  {

  }
public UppercaseViewModel getUppercaseViewModel()
{
  if (uppercaseVM==null)
  {
    uppercaseVM = new UppercaseViewModel();
  }
  return uppercaseVM;}
}
