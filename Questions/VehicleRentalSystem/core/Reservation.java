package Questions.VehicleRentalSystem.core;

import Questions.VehicleRentalSystem.core.Model.User;
import Questions.VehicleRentalSystem.core.Model.Vehicle;
import Questions.VehicleRentalSystem.enums.ReservationStatus;
import Questions.VehicleRentalSystem.enums.ReservationType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    private String reservationId;
    private User user;
    private Vehicle vehicle;
    private LocalDateTime pickUpTime;
    private LocalDateTime dropTime;
    private Location pickUpLocation;
    private Location dropLocation;
    private ReservationStatus reservationStatus;
    private ReservationType reservationType;

    public Reservation(User user, Vehicle vehicle, LocalDateTime pickUpTime, LocalDateTime dropTime, Location pickUpLocation, Location dropLocation, ReservationType reservationType){
        this.reservationId = UUID.randomUUID().toString();
        this.user = user;
        this.vehicle = vehicle;
        this.pickUpTime = pickUpTime;
        this.dropTime = dropTime;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
        this.reservationType = reservationType;
        this.reservationStatus = ReservationStatus.SCHEDULED;
    }

    public String getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getPickUpTime() {
        return pickUpTime;
    }

    public LocalDateTime getDropTime() {
        return dropTime;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
