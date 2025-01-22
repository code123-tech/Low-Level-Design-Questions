package Questions.ParkingLots.ParkingLot2.model.Parking.spots;

import Questions.ParkingLots.ParkingLot2.model.enums.ParkingSpotType;

public class TwoWheelerVehicleParkingSpot extends ParkingSpot {

    public TwoWheelerVehicleParkingSpot(String id) {
        super(id, ParkingSpotType.TWO_WHEELER);
    }
}
