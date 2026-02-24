package smartHomeProject;

public class Rule {
    private String ruleName;
    private int startTime; // 0-23 hours
    private int endTime;   
    private boolean deviceShouldBeOn; // state of device during this rule

    public Rule(String ruleName, int startTime, int endTime, boolean deviceShouldBeOn) {
        this.ruleName = ruleName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.deviceShouldBeOn = deviceShouldBeOn;
    }

    public String getRuleName() {
        return ruleName;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public boolean getDeviceShouldBeOn() {
        return deviceShouldBeOn;
    }

    @Override
    public String toString() {
        return ruleName + " | On: " + startTime + ":00 - Off: " + endTime + ":00";
    }
}
