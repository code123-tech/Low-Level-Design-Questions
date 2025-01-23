package Questions.ParkingLots.ParkingLot2.model.Parking;

import java.time.LocalDateTime;
import java.util.UUID;

import Questions.ParkingLots.ParkingLot2.model.Common.EntityDefinition;
import Questions.ParkingLots.ParkingLot2.model.Parking.spots.ParkingSpot;
import Questions.ParkingLots.ParkingLot2.model.Vehicle.Vehicle;
import Questions.ParkingLots.ParkingLot2.model.enums.TicketStatus;

public class ParkingEntryPoint extends EntityDefinition {

    public ParkingEntryPoint(String id) {
        super(id);
    }

    public ParkingTicket issueParkingTicket(Vehicle vehicle) {
        
        ParkingSpot parkingSpot = ParkingLot.INSTANCE.parkVehicle(vehicle.getVehicleType());
        if(parkingSpot == null){
            return null;
        }
        return buildParkingTicket(vehicle.getVehicleNumber(), parkingSpot.getId());
    }

    private ParkingTicket buildParkingTicket(String vehicleNumber, String allocateParkingSpotId) {

        ParkingTicket parkingTicket = new ParkingTicket();

        parkingTicket.setTicketNumber(UUID.randomUUID().toString());
        parkingTicket.setVehicleNumber(vehicleNumber);
        parkingTicket.setAllocatedParkingSpotId(allocateParkingSpotId);
        parkingTicket.setIssuedAt(LocalDateTime.now());
        parkingTicket.setTicketStatus(TicketStatus.ACTIVE);

        return parkingTicket;
    }
}
