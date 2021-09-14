package view.uppercase;

import javafx.beans.property.StringProperty;

import java.security.PublicKey;

public class UppercaseViewModel
{
  private StringProperty request;
  private StringProperty reply;
  private StringProperty error;

  public UppercaseViewModel()
  {

  }
  public void convert()
  {
    System.out.println("Hello from VM");
  }
  public StringProperty errorProperty()
  {
    return error;
  }
  public StringProperty requestProperty()
  {
    return request;
  }
  public StringProperty replyProperty()
  {
    return reply;
  }

}
