package Questions.ParkingLot.core.SlotsType;

public class TwoWheelerParkingSlotType implements ParkingSlotType{

    private final Double TWO_WHEELER_SLOT_CHARGE_PER_HOUR = 0.05;
    private final String PARKING_SLOT_TYPE = "TWO_WHEELER";

    public Double calculateCost(Long duration) {
        return TWO_WHEELER_SLOT_CHARGE_PER_HOUR *duration;
    }

    public String getPARKING_SLOT_TYPE() {
        return PARKING_SLOT_TYPE;
    }
}
