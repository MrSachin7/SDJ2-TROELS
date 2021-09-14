package view.uppercase;

import core.ViewModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TextConverter;
import model.TextConverterModel;

import java.security.PublicKey;

public class UppercaseViewModel
{
  private StringProperty request= new SimpleStringProperty();
  private StringProperty reply= new SimpleStringProperty();
  private StringProperty error= new SimpleStringProperty();
  public TextConverter textConverter;

  public UppercaseViewModel(TextConverter textConverter)
  {
    this.textConverter = textConverter;

  }

  public void convert()
  {
    String input = request.get();
    if (!(input == null) && !("").equals(input))
    {
      String result = textConverter.toUpperCase(input);
      error.set(result);
    }
    else
    {
      error.set("Input cannot be empty");
    }
  }

  public StringProperty errorProperty()
  {
   /* if (error == null)
    {
      error = new SimpleStringProperty();
    }**/
    return error;
  }

  public StringProperty requestProperty()
  {
  /*  if (request == null)
    {
      request = new SimpleStringProperty();
    }**/
    return request;
  }

  public StringProperty replyProperty()
  {
    /*if (reply == null)
    {
      reply = new SimpleStringProperty();
    }**/
    return reply;
  }

}
