package Questions.VehicleRentalSystem.core.Model;

import Questions.VehicleRentalSystem.core.Location;
import Questions.VehicleRentalSystem.core.Reservation;
import Questions.VehicleRentalSystem.core.VehicleInventory;
import Questions.VehicleRentalSystem.enums.ReservationType;
import Questions.VehicleRentalSystem.enums.VehicleStatus;
import Questions.VehicleRentalSystem.enums.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Store {
    private String storeId;
    private String storeName;
    private VehicleInventory vehicleInventory;
    private List<Reservation> reservations = new ArrayList<>();
    private Location storeLocation;

    public Store(String storeName, Location storeLocation, List<Vehicle> vehicles){
        this.storeId = UUID.randomUUID().toString();
        this.vehicleInventory = new VehicleInventory(vehicles);
        this.storeLocation = storeLocation;
        this.storeName = storeName;
    }

    public List<Vehicle> getAllAvailableVehicles(VehicleType vehicleType){
        if(this.vehicleInventory == null){
            System.out.println("Store with id: " + this.storeId + " and name: " + this.storeName + " has no vehicle.");
            return null;
        }
        return this.vehicleInventory.getAllAvailableVehicles(vehicleType);
    }

    public Reservation reserveVehicle(User user, Vehicle vehicle, LocalDateTime pickUpTime, LocalDateTime dropTime, Location pickUpLocation, Location dropLocation, ReservationType reservationType){
        Reservation reservation = new Reservation(user, vehicle, pickUpTime, dropTime, pickUpLocation, dropLocation, reservationType);
        reservation.getVehicle().setVehicleStatus(VehicleStatus.RENTED);
        this.reservations.add(reservation);
        return reservation;
    }

    public void completeJourney(Reservation reservation){
        this.reservations.remove(reservation);
        reservation.getVehicle().setVehicleStatus(VehicleStatus.AVAILABLE);
        System.out.println("Vehicle: " + reservation.getVehicle().getVehicleNumber() + " is dropped at store");
    }

    public String getStoreId() {
        return this.storeId;
    }

    public VehicleInventory getVehicleInventory() {
        return this.vehicleInventory;
    }

    public List<Reservation> getReservations() {
        return this.reservations;
    }

    public Location getStoreLocation() {
        return this.storeLocation;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
