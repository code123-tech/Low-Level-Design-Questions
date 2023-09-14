package Questions.ParkingLot.core.SlotsType;

public class CompactParkingSlotType implements ParkingSlotType{
    private final Double COMPACT_SLOT_CHARGE_PER_HOUR = 0.5;
    private final String PARKING_SLOT_TYPE = "COMPACT";
    public Double calculateCost(Long duration) {
        return COMPACT_SLOT_CHARGE_PER_HOUR *duration;
    }

    public String getPARKING_SLOT_TYPE() {
        return PARKING_SLOT_TYPE;
    }
}
