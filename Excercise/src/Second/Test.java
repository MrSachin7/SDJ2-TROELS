package Second;

import java.util.ArrayList;

public class Test
{
  public static void main(String[] args) throws InterruptedException
  {
    Car car1 = new Car(1);
    Car car2 = new Car(2);
    Car car3 = new Car(3);
    Pedestrian p1 = new Pedestrian(1);
    Pedestrian p2 = new Pedestrian(2);

   /* ArrayList<Car> cars= new ArrayList<>();
    cars.add(car1);
    cars.add(car2);
    cars.add(car3); **/

    ArrayList<TrafficLightParticipants> trafficLightParticipants = new ArrayList<>();
    trafficLightParticipants.add(car1);
    trafficLightParticipants.add(car2);
    trafficLightParticipants.add(car3);
    trafficLightParticipants.add(p1);
    trafficLightParticipants.add(p2);

    TrafficLight trafficLight = new TrafficLight(trafficLightParticipants);
    trafficLight.start();
  }
}
