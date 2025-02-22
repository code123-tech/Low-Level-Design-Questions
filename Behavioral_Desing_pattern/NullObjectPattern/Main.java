package Behavioral_Desing_pattern.NullObjectPattern;

import Behavioral_Desing_pattern.NullObjectPattern.vehicles.Vehicle1;
import Behavioral_Desing_pattern.NullObjectPattern.vehicles.Vehicle2;
import Behavioral_Desing_pattern.NullObjectPattern.vehicles.VehicleInterface;
import Behavioral_Desing_pattern.NullObjectPattern.vehicles.VehicleNPEHandler;

public class Main {

    public static void main(String[] args) {
        
        VehicleInterface vehicle1 = new Vehicle1();
        VehicleInterface vehicle2 = new Vehicle2();
        VehicleInterface npeHandlerVehicle = new VehicleNPEHandler();


        VehicleRentalService vehicleRentalService1 = new VehicleRentalService(vehicle1);
        VehicleRentalService vehicleRentalService2 = new VehicleRentalService(vehicle2);
        VehicleRentalService vehicleRentalService3 = new VehicleRentalService(npeHandlerVehicle);

        vehicleRentalService1.rentVehicle();
        vehicleRentalService2.rentVehicle();
        vehicleRentalService3.rentVehicle();
    }
}
