package Questions.ParkingLots.ParkingLot1.core.SlotsType;

public class LargeParkingSlotType implements ParkingSlotType{
    private final Double LARGE_SLOT_CHARGE_PER_HOUR = 0.1;
    private final String PARKING_SLOT_TYPE = "LARGE";

    public Double calculateCost(Long duration) {
        return LARGE_SLOT_CHARGE_PER_HOUR *duration;
    }

    public String getPARKING_SLOT_TYPE() {
        return PARKING_SLOT_TYPE;
    }
}
