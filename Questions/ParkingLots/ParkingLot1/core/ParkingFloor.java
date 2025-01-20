package Questions.ParkingLots.ParkingLot1.core;

import java.util.Map;

import Questions.ParkingLots.ParkingLot1.core.Model.Vehicle;
import Questions.ParkingLots.ParkingLot1.core.SlotsType.ParkingSlotType;
import Questions.ParkingLots.ParkingLot1.core.factory.ParkingSlotTypeFactory;
import Questions.ParkingLots.ParkingLot1.enums.ParkingSlotStatus;
import Questions.ParkingLots.ParkingLot1.enums.VehicleCategory;

public class ParkingFloor {
    private Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots;

    public ParkingFloor(Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots){
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
