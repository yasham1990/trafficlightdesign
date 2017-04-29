//Implementation class of the traffic light interface.
public class TrafficLightImpl implements TrafficLight {

    private TrafficLightState state;
    private String lightDirection;

    public TrafficLightImpl(String lightDirection) {
        this.state = TrafficLightState.RED;
        this.lightDirection = lightDirection;
    }
    
    public TrafficLightState getState() {
        return state;
    }
    
    public void printStatus(){
    	System.out.println(lightDirection +":" +getState());
    }

    public void setState(TrafficLightState newState) {
        this.state = newState;
    }
    
}
