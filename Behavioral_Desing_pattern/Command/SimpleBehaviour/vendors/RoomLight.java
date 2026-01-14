package Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors;

public class RoomLight implements Light {
    @Override
    public void turnOn() {
        System.out.println("Room light is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Room light is turned OFF");
    }
}
