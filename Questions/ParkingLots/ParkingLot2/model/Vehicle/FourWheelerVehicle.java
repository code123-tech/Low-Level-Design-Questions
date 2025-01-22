package Questions.ParkingLots.ParkingLot2.model.Vehicle;

import Questions.ParkingLots.ParkingLot2.model.enums.VehicleType;

public class FourWheelerVehicle extends Vehicle {

    public FourWheelerVehicle(String vehicleNumber){
        super(vehicleNumber, VehicleType.FOUR_WHEELER);
    }
}
