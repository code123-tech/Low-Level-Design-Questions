package Questions.ParkingLots.ParkingLot1.core;

import java.util.List;
import java.util.Map;

import Questions.ParkingLots.ParkingLot1.core.Model.Address;
import Questions.ParkingLots.ParkingLot1.core.Model.Ticket;
import Questions.ParkingLots.ParkingLot1.core.Model.Vehicle;
import Questions.ParkingLots.ParkingLot1.core.SlotsType.ParkingSlotType;
import Questions.ParkingLots.ParkingLot1.enums.TicketStatus;

public class ParkingLot {
    private String nameOfParkingLot;
    private Address address;

    private List<ParkingFloor> parkingFloors;

    private static ParkingLot parkingLot = null;

    private ParkingLot(String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors) {
        this.nameOfParkingLot = nameOfParkingLot;
        this.parkingFloors = parkingFloors;
        this.address = address;
    }

    public static ParkingLot getInstance(String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors){
        if(parkingLot == null){
            parkingLot = new ParkingLot(nameOfParkingLot, address, parkingFloors);
        }
        return parkingLot;
    }

    public void addFloors(Map<ParkingSlotType, Map<String, ParkingSlot>> slots){
        ParkingFloor parkingFloor = new ParkingFloor(slots);
        this.parkingFloors.add(parkingFloor);
    }

    public void removeParkingFloor(ParkingFloor parkingFloor){
        if(parkingFloor == null){
            System.out.println("Invalid parking floor");
            return;
        }
        this.parkingFloors.remove(parkingFloor);
    }

    public Ticket assignTicketToVehicle(Vehicle vehicle){
        ParkingSlot parkingSlot = getParkingSlotForVehicleAndPark(vehicle);
        if(parkingSlot == null) return null;

        Ticket ticket = Ticket.createTicket(vehicle, parkingSlot);
        return ticket;
    }

    public Double scanAndPay(Ticket ticket){
        if(ticket.getTicketStatus().equals(TicketStatus.PAID)){
            System.out.println("Ticket with number: " + ticket.getTicketNumber() + " is already paid.");
            return 0.0;
        }
        if(ticket.getTicketStatus().equals(TicketStatus.LOST)){
            System.out.println("Ticket with number: " + ticket.getTicketNumber() + " is lost.");
            return 0.0;
        }
        Long endTime = System.currentTimeMillis();
        ticket.setEndTime(endTime);

        ticket.getParkingSlot().removeVehicle();
        Long duration = (endTime - ticket.getStartTime()) /1000;
        Double price = ticket.getParkingSlot().getParkingSlotType().calculateCost(duration);
        ticket.setTicketStatus(TicketStatus.PAID);
        return price;
    }
    private ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle){
        ParkingSlot parkingSlot = null;
        for(ParkingFloor floor: parkingFloors){
            parkingSlot = floor.getParkingSlotForVehicleAndPark(vehicle);
            if(parkingSlot != null) break;
        }
        return parkingSlot;
    }
    /**  Getters, Setters  */
    public String getNameOfParkingLot() {
        return nameOfParkingLot;
    }

    public void setNameOfParkingLot(String nameOfParkingLot) {
        this.nameOfParkingLot = nameOfParkingLot;
    }

    public Address getAddress() {
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
}
