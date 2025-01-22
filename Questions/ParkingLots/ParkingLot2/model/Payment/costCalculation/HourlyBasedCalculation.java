package Questions.ParkingLots.ParkingLot2.model.Payment.costCalculation;

import java.util.HashMap;
import java.util.Map;

import Questions.ParkingLots.ParkingLot2.model.enums.ParkingSpotType;

public class HourlyBasedCalculation extends CostCalculation {

    private Map<ParkingSpotType, Double> hourlyCosts = new HashMap<>();

    public HourlyBasedCalculation() {
        hourlyCosts.put(ParkingSpotType.TWO_WHEELER, 20.0);
        hourlyCosts.put(ParkingSpotType.FOUR_WHEELER, 30.0);
        hourlyCosts.put(ParkingSpotType.LARGE, 40.0);
        hourlyCosts.put(ParkingSpotType.ABLED, 15.0);
    }

    @Override
    public double getCost(ParkingSpotType parkingSpotType) {
        return hourlyCosts.get(parkingSpotType);
    }

    public Map<ParkingSpotType, Double> getHourlyCosts() {
        return hourlyCosts;
    }
}
