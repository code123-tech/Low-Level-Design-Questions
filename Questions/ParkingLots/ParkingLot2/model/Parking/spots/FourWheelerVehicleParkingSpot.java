package Questions.ParkingLots.ParkingLot2.model.Parking.spots;

import Questions.ParkingLots.ParkingLot2.model.enums.ParkingSpotType;

public class FourWheelerVehicleParkingSpot extends ParkingSpot{

    public FourWheelerVehicleParkingSpot(String id) {
        super(id, ParkingSpotType.FOUR_WHEELER);
    }
}
