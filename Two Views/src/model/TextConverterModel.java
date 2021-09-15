package model;

import java.util.ArrayList;
import java.util.List;

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
    public List<String> getLog()
    {
        if (list == null) {
            list = new ArrayList<String>();
        }
        return list;
    }
    @Override
    public int getLogSize()
    {
        return list.size();
    }
}
