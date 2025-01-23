package Questions.ParkingLots.ParkingLot2.model.Parking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Questions.ParkingLots.ParkingLot2.model.Common.EntityDefinition;
import Questions.ParkingLots.ParkingLot2.model.Parking.spots.ParkingSpot;
import Questions.ParkingLots.ParkingLot2.model.User.Address;
import Questions.ParkingLots.ParkingLot2.model.enums.VehicleType;

public class ParkingLot extends EntityDefinition{

    private Address address;

    private List<ParkingFloor> parkingFloors;
    private List<ParkingEntryPoint> parkingEntryPoints;
    private List<ParkingExitPoint> parkingExitPoints;

    public static ParkingLot INSTANCE = new ParkingLot();

    private ParkingLot() {
        super(UUID.randomUUID().toString());
        parkingFloors = new ArrayList<>();
        parkingEntryPoints = new ArrayList<>();
        parkingExitPoints = new ArrayList<>();
    }

    public boolean isParkingLotFull(){
        return ParkingLot.INSTANCE.getParkingFloors().stream().allMatch(ParkingFloor::isParkingFloorFull);
    }

    public boolean canParkVehicle(VehicleType vehicleType){
        return ParkingLot.INSTANCE.getParkingFloors().stream().anyMatch(floor -> floor.canParkVehicle(vehicleType));
    }

    public ParkingSpot parkVehicle(VehicleType vehicleType){

        for (ParkingFloor parkingFloor : ParkingLot.INSTANCE.getParkingFloors()) {
            ParkingSpot parkingSpot = parkingFloor.parkVehicle(vehicleType);
            if (parkingSpot != null) {
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot unParkVehicle(String parkingSpotId){

        for (ParkingFloor parkingFloor : ParkingLot.INSTANCE.getParkingFloors()) {
            ParkingSpot parkingSpot = parkingFloor.unParkVehicle(parkingSpotId);
            if (parkingSpot != null) {
                return parkingSpot;
            }
        }
        return null;
    }

    private Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<ParkingEntryPoint> getParkingEntryPoints() {
        return parkingEntryPoints;
    }

    public void setParkingEntryPoints(List<ParkingEntryPoint> parkingEntryPoints) {
        this.parkingEntryPoints = parkingEntryPoints;
    }   

    public List<ParkingExitPoint> getParkingExitPoints() {
        return parkingExitPoints;
    }

    public void setParkingExitPoints(List<ParkingExitPoint> parkingExitPoints) {
        this.parkingExitPoints = parkingExitPoints;
    }   
}
