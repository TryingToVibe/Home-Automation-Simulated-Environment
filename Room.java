package smartHomeProject;
import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Devices> devices;
    private Rule rule;

    public Room(String name, Rule rule) {
        this.name = name;
        this.rule = rule;
        this.devices = new ArrayList<>();
    }

    // add device 
    public void addDevice(Devices device) {
        devices.add(device);
    }

    // executes the rule against current time
  
    public void executeRule(int currentHour) {
        if (currentHour >= rule.getStartTime() && currentHour < rule.getEndTime()) {
            if (rule.getDeviceShouldBeOn()) {
                for (Devices d : devices) d.setOn();
            }
        } else {
            for (Devices d : devices) d.setOff();
        }
    }

    // getters
    public String getName() {
        return name;
    }

    public ArrayList<Devices> getDevices() {
        return devices;
    }

    public Rule getRule() {
        return rule;
    }

    @Override
    public String toString() {
        return "Room: " + name + " | Rule: " + rule.getRuleName() + " | Devices: " + devices;
    }
}
