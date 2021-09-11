package Second;

public class Pedestrian implements TrafficLightParticipants
{
  private int id;

  public Pedestrian(int id )
  {
    this.id = id;
  }

  @Override public void setLight(String light)
  {
    if (light.equals("GREEN"))
    {
      System.out.println("Pedestrian "+id +" waits");
    }
    else if(light.equals("RED"))
    {
      System.out.println("Pedestrian "+id+" moves");
    }
    else
    {
      System.out.println("Pedestrian "+id+" is still waiting");
    }
  }
}
