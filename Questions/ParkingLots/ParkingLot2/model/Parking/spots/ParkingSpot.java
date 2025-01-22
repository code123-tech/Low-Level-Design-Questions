package Questions.ParkingLots.ParkingLot2.model.Parking.spots;

import Questions.ParkingLots.ParkingLot2.model.Common.EntityDefinition;
import Questions.ParkingLots.ParkingLot2.model.enums.ParkingSpotType;

public abstract class ParkingSpot extends EntityDefinition {

    private ParkingSpotType parkingSpotType;
    private boolean isOccupied;
    private String assignedVehicleId;

    public ParkingSpot(String id, ParkingSpotType parkingSpotType) {
        super(id);
        this.parkingSpotType = parkingSpotType;
    }


    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public String getAssignedVehicleId() {
        return assignedVehicleId;
    }

    public void setAssignedVehicleId(String assignedVehicleId) {
        this.assignedVehicleId = assignedVehicleId;
    }

    public void assignVehicleToSpot(String vehicleId) {
        this.assignedVehicleId = vehicleId;
        this.isOccupied = true;
    }

    public void freeParkingSpot() {
        this.assignedVehicleId = null;
        this.isOccupied = false;
    }
}
