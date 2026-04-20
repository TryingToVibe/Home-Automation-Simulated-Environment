package rules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RuleData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//general rule requirements
	private String ruleName;
	private int startHour;
	private int startMinute;
	private String targetType;
	
	//rule targerts and actions
	private List<String> targetRoomNames = new ArrayList<>();
	private List<String> targetDeviceIDs = new ArrayList<>();
	private List<ActionData> actions = new ArrayList<>();
	
	public String getRuleName() {
		return ruleName;
	}
	
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	
	public int getStartHour() {
		return startHour;
	}
	
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	
	public int getStartMinute() {
		return startMinute;
	}
	
	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}
	
	public String getTargetType() {
		return targetType;
	}
	
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	
	public List<String> getTargetRoomNames() {
		return targetRoomNames;
	}
	
	public void setTargetRoomNames(List<String> targetRoomNames) {
		this.targetRoomNames = targetRoomNames;
	}
	
	public List<String> getTargetDeviceIDs() {
		return targetDeviceIDs;
	}
	
	public void setTargetDeviceIDs(List<String> targetDeviceIDs) {
		this.targetDeviceIDs = targetDeviceIDs;
	}
	
	public List<ActionData> getActions() {
		return actions;
	}
	
	public void setActions(List<ActionData> actions) {
		this.actions = actions;
	}
	
	

}
