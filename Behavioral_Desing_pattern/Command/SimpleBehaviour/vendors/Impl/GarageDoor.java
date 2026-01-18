package Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.Impl;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.IGarageDoor;

public class GarageDoor implements IGarageDoor {

    private final String location;

    public GarageDoor(String location) {
        this.location = location;
    }

    @Override
    public void up() {
        System.out.printf("%s Door is Open\n", this.location);
    }

    @Override
    public void down() {
        System.out.printf("%s Door is Closed\n", this.location);
    }
}
