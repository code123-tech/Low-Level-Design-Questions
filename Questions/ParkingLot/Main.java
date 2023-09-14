package Questions.ParkingLot;

import Questions.ParkingLot.core.Model.Address;
import Questions.ParkingLot.core.Model.Ticket;
import Questions.ParkingLot.core.Model.Vehicle;
import Questions.ParkingLot.core.ParkingFloor;
import Questions.ParkingLot.core.ParkingLot;
import Questions.ParkingLot.core.ParkingSlot;
import Questions.ParkingLot.core.SlotsType.ParkingSlotType;
import Questions.ParkingLot.core.factory.ParkingSlotTypeFactory;
import Questions.ParkingLot.enums.VehicleCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static ParkingLot parkingLot;

    static {
        String parkingLotName = "ABC parking.";
        Address parkingLotAddress = new Address("Y Street", "H-Block", "Ex", "Rj", "In");
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        parkingLot = ParkingLot.getInstance(parkingLotName, parkingLotAddress, parkingFloors);

        // ParkingFloor1
        String parkingFloor1Name = "Floor-1";
        Map<ParkingSlotType, Map<String, ParkingSlot>> allSlots = new HashMap<>();

        // Two wheeler Slots
        Map<String, ParkingSlot> twoWheelerSlots = new HashMap<>();
        ParkingSlotType twoWheelerParkingSlotType = ParkingSlotTypeFactory.getParkingSlotType(VehicleCategory.TWO_WHEELER);
        twoWheelerSlots.put("TW-1", new ParkingSlot("PS-1", twoWheelerParkingSlotType));
        twoWheelerSlots.put("TW-2", new ParkingSlot("PS-2", twoWheelerParkingSlotType));
        twoWheelerSlots.put("TW-3", new ParkingSlot("PS-3", twoWheelerParkingSlotType));
        allSlots.put(twoWheelerParkingSlotType, twoWheelerSlots);

        // Compact Slots
        Map<String, ParkingSlot> compactVehicleSlots = new HashMap<>();
        ParkingSlotType compactParkingSlotType = ParkingSlotTypeFactory.getParkingSlotType(VehicleCategory.HATCHBACK);
        compactVehicleSlots.put("COM-1", new ParkingSlot("PS-1", compactParkingSlotType));
        compactVehicleSlots.put("COM-2", new ParkingSlot("PS-2", compactParkingSlotType));
        compactVehicleSlots.put("COM-3", new ParkingSlot("PS-3", compactParkingSlotType));
        allSlots.put(compactParkingSlotType, compactVehicleSlots);

        // Two wheeler Slots
        Map<String, ParkingSlot> mediumSlots = new HashMap<>();
        ParkingSlotType mediumParkingSlotType = ParkingSlotTypeFactory.getParkingSlotType(VehicleCategory.SUV);
        mediumSlots.put("M-1", new ParkingSlot("PS-1", mediumParkingSlotType));
        mediumSlots.put("M-2", new ParkingSlot("PS-2", mediumParkingSlotType));
        mediumSlots.put("M-3", new ParkingSlot("PS-3", mediumParkingSlotType));
        allSlots.put(mediumParkingSlotType, mediumSlots);

        // Two wheeler Slots
        Map<String, ParkingSlot> largeSlots = new HashMap<>();
        ParkingSlotType largeParkingSlotType = ParkingSlotTypeFactory.getParkingSlotType(VehicleCategory.BUS);
        largeSlots.put("L-1", new ParkingSlot("PS-1", largeParkingSlotType));
        largeSlots.put("L-2", new ParkingSlot("PS-2", largeParkingSlotType));
        largeSlots.put("L-3", new ParkingSlot("PS-3", largeParkingSlotType));
        allSlots.put(largeParkingSlotType, largeSlots);

        parkingLot.addFloors(parkingFloor1Name, allSlots);

    }

    public static void main(String[] args) throws InterruptedException {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleCategory(VehicleCategory.TWO_WHEELER);
        vehicle1.setVehicleNumber("KA-01-MA-9999");
        Ticket ticket1 = parkingLot.assignTicketToVehicle(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleCategory(VehicleCategory.TWO_WHEELER);
        vehicle2.setVehicleNumber("KA-01-MA-9912");
        Ticket ticket2 = parkingLot.assignTicketToVehicle(vehicle2);

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setVehicleCategory(VehicleCategory.TWO_WHEELER);
        vehicle3.setVehicleNumber("KA-01-MA-9910");
        Ticket ticket3 = parkingLot.assignTicketToVehicle(vehicle3);

        if(ticket1 == null){
            System.out.println("Sorry, Parking is full..");
        }else{
            System.out.println("Ticket Number for vehicle1: " + vehicle1.getVehicleNumber() + " is: " + ticket1.getTicketNumber());

            Thread.sleep(1000);
            Double price = parkingLot.scanAndPay(ticket1);
            System.out.println("Price for vehicle1: " + vehicle1.getVehicleNumber() + " is: " + price);
        }

        if(ticket2 == null){
            System.out.println("Sorry, Parking is full..");
        }else{
            System.out.println("Ticket Number for vehicle2: " + vehicle2.getVehicleNumber() + " is: " + ticket2.getTicketNumber());

            Thread.sleep(1000);
            Double price = parkingLot.scanAndPay(ticket2);
            System.out.println("Price for vehicle2: " + vehicle2.getVehicleNumber() + " is: " + price);
        }


        if(ticket3 == null){
            System.out.println("Sorry, Parking is full..");
        }else{
            System.out.println("Ticket Number for vehicle3: " + vehicle3.getVehicleNumber() + " is: " + ticket2.getTicketNumber());

            Thread.sleep(1000);
            Double price = parkingLot.scanAndPay(ticket3);
            System.out.println("Price for vehicle3: " + vehicle3.getVehicleNumber() + " is: " + price);
        }
    }
}
