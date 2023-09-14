package Questions.ParkingLot.core;

import Questions.ParkingLot.core.Model.Vehicle;
import Questions.ParkingLot.core.SlotsType.ParkingSlotType;
import Questions.ParkingLot.core.factory.ParkingSlotTypeFactory;
import Questions.ParkingLot.enums.ParkingSlotStatus;
import Questions.ParkingLot.enums.VehicleCategory;

import java.util.Map;

public class ParkingFloor {
    private String floorName;
    private Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots;

    public ParkingFloor(String floorName, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots){
        this.floorName = floorName;
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle){
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = ParkingSlotTypeFactory.getParkingSlotType(vehicleCategory);
        Map<String, ParkingSlot> relevantParkingSlots = parkingSlots.get(parkingSlotType);
        ParkingSlot parkingSlot = null;
        for(Map.Entry<String, ParkingSlot> slot: relevantParkingSlots.entrySet()) {
            if(slot.getValue().getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)){
                parkingSlot = slot.getValue();
                parkingSlot.addVehicle(vehicle);
                break;
            }
        }
        return parkingSlot;
    }
}
