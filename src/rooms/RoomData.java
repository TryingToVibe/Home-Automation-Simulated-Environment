package rooms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoomData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String roomName;
	private List<String> deviceIDs = new ArrayList<>();
	
	public String getRoomName() {
		return roomName;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public List<String> getDeviceIDs() {
		return deviceIDs;
	}
	
	public void setDeviceIDs(List<String> deviceIDs) {
		this.deviceIDs = deviceIDs;
	}

}
