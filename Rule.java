package smartHomeProject;
import java.util.ArrayList;

public class Rule {
	private String ruleName;
	private int startTimeHours; // 0-23 hours
	private int startTimeMin; //0 - 59 min  
	private boolean deviceShouldBeOn; // state of device during this rule
	private HVAC.Mode desiredMode;
	private int desiredTemp;
	private ArrayList<Devices> targets; //stores all the devices that the rule commands

	//to run devices that just have to turn on (lights)
	public Rule(String ruleName, int startTimeHours, int startTimeMin, boolean deviceShouldBeOn) {
		this.ruleName = ruleName;
		this.startTimeHours = startTimeHours;
		this.startTimeMin = startTimeMin;
		this.deviceShouldBeOn = deviceShouldBeOn;
		
		targets = new ArrayList<>();
	}
	
	public Rule(String ruleName, int startTimeHours, int startTimeMin, boolean deviceShouldBeOn, HVAC.Mode desiredMode, int desiredTemp) {
		this.ruleName = ruleName;
		this.startTimeHours = startTimeHours;
		this.startTimeMin = startTimeMin;
		this.deviceShouldBeOn = deviceShouldBeOn;
		this.desiredMode = desiredMode;
		this.desiredTemp = desiredTemp;
		 
		targets = new ArrayList<>();
	}
	
	//adds devices to targets list
	public void addTarget(Devices device) {
	    targets.add(device);
	}

	//getters	
	public String getRuleName() {
	    return ruleName;
	}
	
	public int getStartTime() {
		return startTimeHours * 60 + startTimeMin;
	}

	public boolean getDeviceShouldBeOn() {
		return deviceShouldBeOn;
	}

	public int getStartHour() {
		return startTimeHours;
	}

	public int getStartMinute() {
		return startTimeMin;
	}
	
	public HVAC.Mode getDesiredMode() {
		return desiredMode;
	}
	
	public int getDesiredTemp() {
		return desiredTemp;
	}
	
	public ArrayList<Devices> getTargets() {
	    return targets;
	}

	@Override
	public String toString() {
		return ruleName + " | On: " + startTimeHours + ":" + startTimeMin;
	}






} // close
