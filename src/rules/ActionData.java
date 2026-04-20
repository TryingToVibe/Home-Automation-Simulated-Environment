package rules;

import java.io.Serializable;

public class ActionData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String actionType;
    private boolean turnOn;
    private String targetClassName;
    private String hvacMode;
    private int hvacTemp;

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public boolean isTurnOn() {
        return turnOn;
    }

    public void setTurnOn(boolean turnOn) {
        this.turnOn = turnOn;
    }

    public String getTargetClassName() {
        return targetClassName;
    }

    public void setTargetClassName(String targetClassName) {
        this.targetClassName = targetClassName;
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