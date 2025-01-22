package Questions.ParkingLots.ParkingLot2.model.Vehicle;

import Questions.ParkingLots.ParkingLot2.model.Parking.ParkingTicket;
import Questions.ParkingLots.ParkingLot2.model.enums.VehicleType;

public abstract class Vehicle {

    private String vehicleNumber;
    private VehicleType vehicleType;
    private ParkingTicket parkingTicket;

    public Vehicle(String vehicleNumber, VehicleType vehicleType){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }
}
