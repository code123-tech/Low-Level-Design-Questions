package Behavioral_Desing_pattern.Command.SimpleBehaviour.commands;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.Light;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
