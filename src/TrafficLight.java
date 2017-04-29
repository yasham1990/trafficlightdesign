
public interface TrafficLight {

    TrafficLightState getState();
    
    void printStatus();
    
    void setState(TrafficLightState state);
    
}
