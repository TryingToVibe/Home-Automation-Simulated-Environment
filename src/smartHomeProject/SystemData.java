package smartHomeProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import devices.DeviceData;
import rooms.RoomData;
import rules.RuleData;


public class SystemData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<DeviceData> devices = new ArrayList<>();
	private List<RoomData> room = new ArrayList<>();
	private List<RuleData> rules = new ArrayList<>();
	private int hours;
	private int minutes;
	
	public List<DeviceData> getDevices() {
		return devices;
	}
	
	public List<RoomData> getRooms() {
		return room;
	}
	
	public List<RuleData> getRules() {
		return rules;
	}
	
	public void setHours(int simulatedTime) {
		this.hours = simulatedTime / 60;
	}
	
	public int getHours() {
		return hours;
	}
	
	public void setMinutes(int simulatedTime) {
		this.minutes = simulatedTime % 60;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
}
