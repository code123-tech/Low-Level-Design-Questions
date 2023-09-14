package Questions.ParkingLot.core;

import Questions.ParkingLot.core.Model.Vehicle;
import Questions.ParkingLot.core.SlotsType.ParkingSlotType;
import Questions.ParkingLot.enums.ParkingSlotStatus;


public class ParkingSlot {
    private String name;
    private ParkingSlotStatus parkingSlotStatus = ParkingSlotStatus.AVAILABLE;

    private Vehicle vehicle;
    private ParkingSlotType parkingSlotType;

    public ParkingSlot(String name, ParkingSlotType parkingSlotType){
        this.name = name;
        this.parkingSlotType = parkingSlotType;
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.parkingSlotStatus = ParkingSlotStatus.BOOKED;
    }

    public void removeVehicle(){
        this.vehicle = null;
        this.parkingSlotStatus = ParkingSlotStatus.AVAILABLE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public void setParkingSlotType(ParkingSlotType parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }
}
