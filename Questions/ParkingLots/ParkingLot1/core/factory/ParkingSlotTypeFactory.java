package Questions.ParkingLots.ParkingLot1.core.factory;

import Questions.ParkingLots.ParkingLot1.core.SlotsType.*;
import Questions.ParkingLots.ParkingLot1.enums.VehicleCategory;

public class ParkingSlotTypeFactory {
    private static final ParkingSlotType twoWheelerParkingSlotType = new TwoWheelerParkingSlotType();
    private static final ParkingSlotType compactParkingSlotType = new CompactParkingSlotType();
    private static final ParkingSlotType mediumParkingSlotType = new MediumParkingSlotType();
    private static final ParkingSlotType largeParkingSlotType = new LargeParkingSlotType();

    public static ParkingSlotType getParkingSlotType(VehicleCategory vehicleCategory){
        switch (vehicleCategory){
            case TWO_WHEELER:
                return twoWheelerParkingSlotType;
            case HATCHBACK:
            case SEDAN:
                return compactParkingSlotType;
            case SUV:
                return mediumParkingSlotType;
            case BUS:
                return largeParkingSlotType;
            default:
                throw new RuntimeException("Illegal vehicle category type.");
        }
    }
}
