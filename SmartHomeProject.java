package smartHomeProject;
import java.util.ArrayList;

public class SmartHomeProject {

	public static void main(String[] args) {
		
		SmartHomeSystem myHouse = new SmartHomeSystem();
		
		Lights kitchenLight = new Lights("Kitchen Light");
		myHouse.registerDevice(kitchenLight);
		
		Lights bedroomLight = new Lights("Bedroom Light");
		myHouse.registerDevice(bedroomLight);
		bedroomLight.setOn();
		
		HVAC masterBedroom = new HVAC("Master Bedroom");
		myHouse.registerDevice(masterBedroom);
		masterBedroom.setMode(HVAC.Mode.AC);
		masterBedroom.setTemp(65);
		
		System.out.print(myHouse.getDevices());
		
		Rule morningRule = new Rule("Morning Routine", 7, 9, true);
		Room kitchen = new Room("Kitchen", morningRule);
		kitchen.addDevice(kitchenLight);
		kitchen.executeRule(8); // simulates 8am

		System.out.println(kitchen);
	
	} // end of main

} // end of class
