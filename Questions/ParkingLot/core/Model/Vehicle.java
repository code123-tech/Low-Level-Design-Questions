package Questions.ParkingLot.core.Model;

import Questions.ParkingLot.enums.VehicleCategory;

public class Vehicle {
    private String vehicleNumber;
    private VehicleCategory vehicleCategory;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }
}
