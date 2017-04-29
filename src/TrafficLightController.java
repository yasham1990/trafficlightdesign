import java.util.HashSet;
import java.util.Set;

public class TrafficLightController {

    private TrafficLightControllerState state;
    
    private TrafficLight northLight;
    private TrafficLight eastLight;
    private TrafficLight southLight;
    private TrafficLight westLight;
    
	//Set contains number of the light.
    Set<TrafficLight> trafficLightList=new HashSet<TrafficLight>();

    public TrafficLightController() {
    	//Initially all lights are red.
    	
        this.state = TrafficLightControllerState.INITIALLY_ALL_RED;
        this.northLight = new TrafficLightImpl("NORTH");
        this.northLight.setState(TrafficLightState.RED);
        this.eastLight = new TrafficLightImpl("EAST");
        this.eastLight.setState(TrafficLightState.RED);
        this.southLight = new TrafficLightImpl("SOUTH");
        this.southLight.setState(TrafficLightState.RED);
        this.westLight = new TrafficLightImpl("WEST");
        this.westLight.setState(TrafficLightState.RED);
        trafficLightList.add(northLight);
        trafficLightList.add(southLight);
        trafficLightList.add(eastLight);
        trafficLightList.add(westLight);
    }
    
    //This method prints the current state of each light.
    public void getLightFromList() {
    	for (TrafficLight trafficLight : trafficLightList) {
				trafficLight.printStatus();
		}
    }
    
    //This method set states of the pair of light as passed in arguments others turn to red.
    public void setStates(TrafficLight light1,TrafficLight light2,TrafficLightState trafficLightState){
    	for (TrafficLight trafficLight : trafficLightList) {
			if(trafficLight!=light1 && trafficLight!=light2)
				trafficLight.setState(TrafficLightState.RED);
		}
    	light1.setState(trafficLightState);
    	trafficLightList.add(light1);
    	light2.setState(trafficLightState);
    	trafficLightList.add(light2);
    }

    //This method will switch the lights to next stage.
    public void switchToNextState() {
        state = getNextState();
        if(TrafficLightControllerState.NS_GREEN.equals(state)) {
        	setStates(northLight,southLight,TrafficLightState.GREEN);
        } else if(TrafficLightControllerState.NS_YELLOW.equals(state)) {
        	setStates(northLight,southLight,TrafficLightState.YELLOW);
        } else if(TrafficLightControllerState.EW_GREEN.equals(state)) {
        	setStates(westLight,eastLight,TrafficLightState.GREEN);
        } else if(TrafficLightControllerState.EW_YELLOW.equals(state)) {
        	setStates(westLight,eastLight,TrafficLightState.YELLOW);
        }
    
    }

    //maintain all the stages here.
    private TrafficLightControllerState getNextState() {
        if(TrafficLightControllerState.INITIALLY_ALL_RED.equals(state)) {
            return TrafficLightControllerState.NS_GREEN;
        } else if(TrafficLightControllerState.NS_GREEN.equals(state)) {
            return TrafficLightControllerState.NS_YELLOW;
        } else if(TrafficLightControllerState.NS_YELLOW.equals(state)) {
            return TrafficLightControllerState.EW_GREEN;
        } else if(TrafficLightControllerState.EW_GREEN.equals(state)) {
            return TrafficLightControllerState.EW_YELLOW;
        } else if(TrafficLightControllerState.EW_YELLOW.equals(state)) {
            return TrafficLightControllerState.NS_GREEN;
        }
        return TrafficLightControllerState.INITIALLY_ALL_RED;
    }
    
}

