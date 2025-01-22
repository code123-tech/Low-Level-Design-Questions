package Questions.ParkingLots.ParkingLot2.model.Payment.costCalculation;

import Questions.ParkingLots.ParkingLot2.model.enums.ParkingSpotType;

public abstract class CostCalculation {

    abstract double getCost(ParkingSpotType parkingSpotType);
}
