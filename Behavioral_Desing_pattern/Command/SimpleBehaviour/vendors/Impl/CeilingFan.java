package Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.Impl;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.ICeilingFan;

public class CeilingFan implements ICeilingFan {

    private final String location;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
        this.speed = OFF;
    }

    @Override
    public void high() {
        speed = HIGH;
        System.out.printf("%s Ceiling Fan is on High\n", this.location);
    }

    @Override
    public void medium() {
        speed = MEDIUM;
        System.out.printf("%s Ceiling Fan is on Medium\n", this.location);
    }

    @Override
    public void low() {
        speed = LOW;
        System.out.printf("%s Ceiling Fan is on Low\n", this.location);
    }

    @Override
    public void off() {
        speed = OFF;
        System.out.printf("%s Ceiling Fan is Off\n", this.location);
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
