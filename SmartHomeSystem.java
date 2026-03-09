package smartHomeProject;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SmartHomeSystem {
	private ArrayList<Devices> deviceList; //storage list for all devices
	private ArrayList<Rule> ruleList;
	private int simulatedTime = 0;

	public SmartHomeSystem() { //constructor
		deviceList = new ArrayList<>();
		ruleList = new ArrayList<>();
	}

	public void registerDevice(Devices device) { //adds new device to the deviceList array
		deviceList.add(device);
	}

	public ArrayList<Devices> getDevices() { //returns the deviceList array
		return deviceList;
	}

	public void addRule(Rule rule) {
		ruleList.add(rule);
	}


	// executes the rule against current time

	public void executeRules(int simulatedTime) {

		for(Rule rule : ruleList) {
			if (simulatedTime == rule.getStartTime() && simulatedTime <= rule.getStartTime() + 1) { //the part after && gives a slight buffer for error management
				System.out.println(rule); // prints the rule that is being executed to the console
				//turns the device on or off
				for (Devices d : rule.getTargets()) {
					if(rule.getDeviceShouldBeOn()) d.setOn();
					else d.setOff();


					//sets HVAC mode and temperature
					if(d instanceof HVAC && rule.getDeviceShouldBeOn()) {
						HVAC h = (HVAC)d;

						h.setMode(rule.getDesiredMode());
						h.setTemp(rule.getDesiredTemp());
					} // closes HVAC for loop

					System.out.println(d);
				} // closes devices for loop


			} // closes time checker


		} // closes the rule for loop
	} // closes executeRules



	//timer (turns 1 real minute into 1 virtual, and 1 real minute into 1 virtual hour, so full virtual days are 24 real minutes)
	public void startSimulation() {

	    Timer timer = new Timer();

	    timer.scheduleAtFixedRate(new TimerTask() {
	    	int hour;
	    	int minute;
	    	
	        @Override
	        public void run() {

	            simulatedTime++; //increased the time by one minute

	            if(simulatedTime >= 1440) simulatedTime = 0; //reset the time after 24 minutes

	            executeRules(simulatedTime); //runs executeRules, which checks if it is time to run commands

	            //prints simulated time to console every real minute
	            hour = simulatedTime / 60;
	            minute = simulatedTime % 60;
	            String timeString = String.format("%02d:%02d", hour, minute);
	            if(simulatedTime % 60 == 0) System.out.println(timeString);
	        }

	    }, 0, 1000); //every second

	}

}