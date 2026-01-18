package Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.Impl;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.ILight;

public class Light implements ILight {

    private final String location;

    public Light(String location) {
        this.location = location;
    }

    @Override
    public void turnOn() {
        System.out.printf("%s light is turned ON\n", this.location);
    }

    @Override
    public void turnOff() {
        System.out.printf("%s light is turned OFF\n", this.location);
    }
}
