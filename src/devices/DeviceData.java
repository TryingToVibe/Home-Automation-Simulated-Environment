package devices;

import java.io.Serializable;

public class DeviceData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//device traits
	private String type;
	private String name;
	private String deviceID;
	private boolean on;
	
	//hvac special traits
	private String hvacMode;
	private int hvacTemp;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDeviceID() {
		return deviceID;
	}
	
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	
	public boolean isOn() {
		return on;
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}
	
	public String getHvacMode() {
		return hvacMode;
	}
	
	public void setHvacMode(String hvacMode) {
		this.hvacMode = hvacMode;
	}
	
	public int getHvacTemp() {
		return hvacTemp;
	}
	
	public void setHvacTemp(int hvacTemp) {
		this.hvacTemp = hvacTemp;
	}
	
	
	
}
