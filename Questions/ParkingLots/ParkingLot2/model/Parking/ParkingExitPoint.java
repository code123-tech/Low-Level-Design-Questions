package Questions.ParkingLots.ParkingLot2.model.Parking;

import java.time.Duration;
import java.time.LocalDateTime;

import Questions.ParkingLots.ParkingLot2.model.Common.EntityDefinition;
import Questions.ParkingLots.ParkingLot2.model.Payment.costCalculation.HourlyBasedCalculation;
import Questions.ParkingLots.ParkingLot2.model.enums.ParkingSpotType;

public class ParkingExitPoint extends EntityDefinition{

    public ParkingExitPoint(String id) {
        super(id);
    }

    public ParkingTicket scanAndExitParkingTicket(ParkingTicket parkingTicket) {

        // 1. vacate parking spot from Parking Lot
        
        // 2. set charges on parking ticket
        parkingTicket.setTotalCost(calculateCharge(parkingTicket, ParkingSpotType.TWO_WHEELER));
        return parkingTicket;
    }

    private double calculateCharge(ParkingTicket parkingTicket, ParkingSpotType parkingSpotType) {

        Duration duration = Duration.between(parkingTicket.getIssuedAt(), LocalDateTime.now());
        
        long hours = duration.toHours();
        if (hours == 0)
            hours = 1;

        double amount = hours * new HourlyBasedCalculation().getCost(parkingSpotType);
        return amount;
    }
}
