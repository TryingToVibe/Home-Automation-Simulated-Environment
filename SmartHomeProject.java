package smartHomeProject;
import java.util.ArrayList;
//this is the driver -----------------------
public class SmartHomeProject { 

	public static void main(String[] args) {

		SmartHomeSystem myHouse = new SmartHomeSystem();
		
		//starts the clock
		myHouse.startSimulation();

		Lights kitchenLight = new Lights("Kitchen Light");
		myHouse.registerDevice(kitchenLight);

		Lights bedroomLight = new Lights("Bedroom Light");
		myHouse.registerDevice(bedroomLight);
		bedroomLight.setOn();

		HVAC masterBedroom = new HVAC("Master Bedroom");
		myHouse.registerDevice(masterBedroom);
		masterBedroom.setMode(HVAC.Mode.AC);
		masterBedroom.setTemp(65);

		System.out.println(myHouse.getDevices());

		//practice rules
		//turns kitchen and bedroom lights on at 11:30
		Rule ruleTestLights = new Rule("RuleTest", 1, 0, true);
		ruleTestLights.addTarget(kitchenLight);
		ruleTestLights.addTarget(bedroomLight);
		myHouse.addRule(ruleTestLights);
		
		//turns master bedroom HVAC on, to AC, and 75 
		Rule ruleTestHVAC = new Rule("RuleTestHVAC", 0, 30, true,  HVAC.Mode.AC, 75);
		ruleTestHVAC.addTarget(masterBedroom);
		myHouse.addRule(ruleTestHVAC);
		
		



	} //end of main

} //end of class
