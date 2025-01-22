package Questions.ParkingLots.ParkingLot2.model.Parking.spots;

import Questions.ParkingLots.ParkingLot2.model.enums.ParkingSpotType;

public class LargeVehicleParkingSpot extends ParkingSpot {

    public LargeVehicleParkingSpot(String id) {
        super(id, ParkingSpotType.LARGE);
    }
}
