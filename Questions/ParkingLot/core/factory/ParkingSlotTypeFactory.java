package Questions.ParkingLot.core.factory;

import Questions.ParkingLot.core.SlotsType.*;
import Questions.ParkingLot.enums.VehicleCategory;

public class ParkingSlotTypeFactory {
    private static ParkingSlotType twoWheelerParkingSlotType = new TwoWheelerParkingSlotType();
    private static ParkingSlotType compactParkingSlotType = new CompactParkingSlotType();
    private static ParkingSlotType mediumParkingSlotType = new MediumParkingSlotType();
    private static ParkingSlotType largeParkingSlotType = new LargeParkingSlotType();

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
