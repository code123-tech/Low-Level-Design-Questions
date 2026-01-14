package Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors;

public class GarageDoor implements IGarageDoor {
    @Override
    public void up() {
        System.out.println("Garage Door is Open");
    }

    @Override
    public void down() {
        System.out.println("Garage Door is Closed");
    }

    @Override
    public void stop() {
        System.out.println("Garage Door is Stopped");
    }

    @Override
    public void lightOn() {
        System.out.println("Garage Light is On");
    }

    @Override
    public void lightOff() {
        System.out.println("Garage Light is Off");
    }
}
