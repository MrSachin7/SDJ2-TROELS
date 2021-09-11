package Second;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class TrafficLight
{

  private String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
  private int count = 2;
  private String currentLight;
  private ArrayList<TrafficLightParticipants> trafficLightParticipants;

  public TrafficLight(
      ArrayList<TrafficLightParticipants> trafficLightParticipants)
  {
    currentLight = lights[count];
    this.trafficLightParticipants = trafficLightParticipants;
  }

  public void start() throws InterruptedException
  {
    for (int i = 0; i < 10; i++)
    {
      Thread.sleep(1000);
      count = (++count) % 4;
      currentLight = lights[count];
      System.out.println("\nLight is " + currentLight);
      for (int j = 0; j < trafficLightParticipants.size(); j++)
      {
        trafficLightParticipants.get(j).setLight(currentLight);
      }
    }

  }

  public void addTrafficParticipants(TrafficLightParticipants participant)
  {
  trafficLightParticipants.add(participant);
  }
}

