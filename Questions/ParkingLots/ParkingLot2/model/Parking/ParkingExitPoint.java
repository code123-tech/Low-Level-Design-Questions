package Questions.ParkingLots.ParkingLot2.model.Parking;

import java.time.Duration;
import java.time.LocalDateTime;

import Questions.ParkingLots.ParkingLot2.model.Common.EntityDefinition;
import Questions.ParkingLots.ParkingLot2.model.Parking.spots.ParkingSpot;
import Questions.ParkingLots.ParkingLot2.model.Payment.costCalculation.HourlyBasedCalculation;
import Questions.ParkingLots.ParkingLot2.model.enums.ParkingSpotType;

public class ParkingExitPoint extends EntityDefinition{

    public ParkingExitPoint(String id) {
        super(id);
    }

    public ParkingTicket scanAndExitParkingTicket(ParkingTicket parkingTicket) {

        ParkingSpot parkingSpot = ParkingLot.INSTANCE.unParkVehicle(parkingTicket.getAllocatedParkingSpotId());
        if(parkingSpot == null){
            return null;
        }

        parkingTicket.setTotalCost(calculateCharge(parkingTicket, parkingSpot.getParkingSpotType()));
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
