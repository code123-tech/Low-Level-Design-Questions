package Behavioral_Desing_pattern.Command.SimpleBehaviour.commands;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.IGarageDoor;

public class GarageDoorOpenCommand implements Command {

    IGarageDoor garageDoor;

    public GarageDoorOpenCommand(IGarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}
