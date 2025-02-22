package Behavioral_Desing_pattern.NullObjectPattern;

import Behavioral_Desing_pattern.NullObjectPattern.vehicles.VehicleInterface;

public class VehicleRentalService {
    
    private VehicleInterface vehicle;

    public VehicleRentalService(VehicleInterface vehicle) {
        this.vehicle = vehicle;
    }

    public void rentVehicle() {
        vehicle.start();
        vehicle.stop();
    }
}
