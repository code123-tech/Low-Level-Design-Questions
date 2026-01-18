package Behavioral_Desing_pattern.Command.SimpleBehaviour.commands;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.ICeilingFan;

public class CeilingFanOnCommand implements Command{

    private final ICeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanOnCommand(ICeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        switch (prevSpeed) {
            case ICeilingFan.HIGH:
                ceilingFan.high();
                break;
            case ICeilingFan.MEDIUM:
                ceilingFan.medium();
                break;
            case ICeilingFan.LOW:
                ceilingFan.low();
                break;
            case ICeilingFan.OFF:
            default:
                ceilingFan.off();
                break;
        }
    }

}
