package Questions.ParkingLots.ParkingLot2.model.Parking;

import java.time.LocalDateTime;

import Questions.ParkingLots.ParkingLot2.model.enums.TicketStatus;

public class ParkingTicket {

    private String ticketNumber;
    private String vehicleNumber;
    private String allocatedParkingSpotId;
    private LocalDateTime issuedAt; 
    private LocalDateTime exitedAt;
    private double totalCost;
    private TicketStatus ticketStatus;

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getAllocatedParkingSpotId() {
        return allocatedParkingSpotId;
    }

    public void setAllocatedParkingSpotId(String allocatedParkingSpotId) {
        this.allocatedParkingSpotId = allocatedParkingSpotId;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }   

    public LocalDateTime getExitedAt() {
        return exitedAt;
    }

    public void setExitedAt(LocalDateTime exitedAt) {
        this.exitedAt = exitedAt;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
