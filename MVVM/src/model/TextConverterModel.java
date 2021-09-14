package model;

import org.w3c.dom.Text;

public class TextConverterModel implements TextConverter
{
  @Override public String toUpperCase(String txt)
  {
   return txt.toUpperCase();
  }
}
