package Behavioral_Desing_pattern.NullObjectPattern.vehicles;

public class Vehicle2 implements VehicleInterface {

    @Override
    public void start() {
        System.out.println("Vehicle2 started");
    }

    @Override
    public void stop() {
        System.out.println("Vehicle2 stopped");
    }

}
