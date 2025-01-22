package Questions.ParkingLots.ParkingLot2.model.Parking.spots;

import Questions.ParkingLots.ParkingLot2.model.enums.ParkingSpotType;

public class AbledVehicleParkingSpot extends ParkingSpot{

    public AbledVehicleParkingSpot(String id){
        super(id, ParkingSpotType.ABLED);
    }
}
