//This class tests the functionality
public class StartClass {
	public static void main(String[] args) {
		TrafficLightController tf=new TrafficLightController();
		
		System.out.println("Initial State");
		tf.getLightFromList();
		System.out.println("Main State Starts");
		try {
			while(true)
			{
				tf.switchToNextState();
				System.out.println("=====================");
				tf.getLightFromList();
				Thread.sleep(50000);
				tf.switchToNextState();
				System.out.println("=====================");
				tf.getLightFromList();
				Thread.sleep(10000);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
