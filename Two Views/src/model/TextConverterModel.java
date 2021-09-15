package model;

import java.util.ArrayList;

public class TextConverterModel implements TextConverter
{
    private ArrayList<String> list;
  @Override public String toUpperCase(String txt)
  {
   return txt.toUpperCase();
  }

    @Override
    public void addLog(String log) {
        list.add(log);
    }
    @Override
    public int getLogSize()
    {
        return list.size();
    }
}
