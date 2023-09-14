package Questions.ParkingLot.core.Model;

import Questions.ParkingLot.core.ParkingSlot;
import Questions.ParkingLot.enums.TicketStatus;

public class Ticket {
    private String ticketNumber;
    private Long startTime;
    private Long endTime;

    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

    private TicketStatus ticketStatus = TicketStatus.ACTIVE;
    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot){
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(vehicle.getVehicleNumber() + System.currentTimeMillis());
        ticket.setStartTime(System.currentTimeMillis());
        ticket.setParkingSlot(parkingSlot);
        ticket.setVehicle(vehicle);
        return ticket;
    }

    /**  Getters, Setters  */
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
