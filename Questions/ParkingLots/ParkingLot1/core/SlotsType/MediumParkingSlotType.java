package Questions.ParkingLots.ParkingLot1.core.SlotsType;

public class MediumParkingSlotType implements ParkingSlotType{
    private final Double MEDIUM_SLOT_CHARGE_PER_HOUR = 0.75;
    private final String PARKING_SLOT_TYPE = "MEDIUM";

    public Double calculateCost(Long duration) {
        return MEDIUM_SLOT_CHARGE_PER_HOUR *duration;
    }

    public String getPARKING_SLOT_TYPE() {
        return PARKING_SLOT_TYPE;
    }
}
