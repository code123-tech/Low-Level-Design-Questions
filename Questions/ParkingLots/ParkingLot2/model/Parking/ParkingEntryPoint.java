package Questions.ParkingLots.ParkingLot2.model.Parking;

import java.time.LocalDateTime;
import java.util.UUID;

import Questions.ParkingLots.ParkingLot2.model.Common.EntityDefinition;
import Questions.ParkingLots.ParkingLot2.model.Vehicle.Vehicle;
import Questions.ParkingLots.ParkingLot2.model.enums.TicketStatus;

public class ParkingEntryPoint extends EntityDefinition {

    public ParkingEntryPoint(String id) {
        super(id);
    }

    public ParkingTicket issueParkingTicket(Vehicle vehicle) {
        
        // need to allocate a parking spot based on the vehicle type
        // 1. check vehicle can be allocated to a parking spot
        
        // 2. allocate a parking spot

        // 3. build a parking ticket
        return buildParkingTicket(vehicle.getVehicleNumber(), "");
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
