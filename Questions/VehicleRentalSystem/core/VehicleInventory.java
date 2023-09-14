package Questions.VehicleRentalSystem.core;

import Questions.VehicleRentalSystem.core.Model.Vehicle;
import Questions.VehicleRentalSystem.enums.VehicleStatus;
import Questions.VehicleRentalSystem.enums.VehicleType;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class VehicleInventory {
    private String id;
    private List<Vehicle> vehicles;

    public VehicleInventory(List<Vehicle> vehicles){
        this.id = UUID.randomUUID().toString();
        this.vehicles = vehicles;
    }

    public String getId(){
        return this.id;
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        this.vehicles.remove(vehicle);
    }

    public List<Vehicle> getAllAvailableVehicles(VehicleType vehicleType){
        return this.vehicles.stream()
                .filter(vehicle -> vehicle.getVehicleStatus().equals(VehicleStatus.AVAILABLE))
                .filter(vehicle -> vehicle.getVehicleType().equals(vehicleType))
                .collect(Collectors.toList());
    }
}
