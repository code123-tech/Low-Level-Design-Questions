package Questions.ParkingLots.ParkingLot2.model.Vehicle;

import Questions.ParkingLots.ParkingLot2.model.enums.VehicleType;

public class TwoWheelerVehicle extends Vehicle {

    public TwoWheelerVehicle(String vehicleNumber){
        super(vehicleNumber, VehicleType.TWO_WHEELER);
    }
}
