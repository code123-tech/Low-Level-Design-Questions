package Behavioral_Desing_pattern.NullObjectPattern.vehicles;

public class Vehicle1 implements VehicleInterface {

    @Override
    public void start() {
        System.out.println("Vehicle1 started");
    }

    @Override
    public void stop() {
        System.out.println("Vehicle1 stopped");
    }

}
