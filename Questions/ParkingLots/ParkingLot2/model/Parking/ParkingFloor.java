package Questions.ParkingLots.ParkingLot2.model.Parking;

import java.util.BitSet;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

import Questions.ParkingLots.ParkingLot2.model.Common.EntityDefinition;
import Questions.ParkingLots.ParkingLot2.model.Parking.spots.ParkingSpot;
import Questions.ParkingLots.ParkingLot2.model.enums.ParkingSpotType;
import Questions.ParkingLots.ParkingLot2.model.enums.VehicleType;

public class ParkingFloor extends EntityDefinition{

    private Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots = new HashMap<>();
    private Map<String, ParkingSpot> usedParkingSpots = new HashMap<>();

    public ParkingFloor(String id) {
        super(id);
        parkingSpots.put(ParkingSpotType.TWO_WHEELER, new ConcurrentLinkedDeque<ParkingSpot>());
        parkingSpots.put(ParkingSpotType.FOUR_WHEELER, new ConcurrentLinkedDeque<ParkingSpot>());
        parkingSpots.put(ParkingSpotType.LARGE, new ConcurrentLinkedDeque<ParkingSpot>());
        parkingSpots.put(ParkingSpotType.ABLED, new ConcurrentLinkedDeque<ParkingSpot>());
    }

    public Map<ParkingSpotType, Deque<ParkingSpot>> getParkingSpots() {
        return parkingSpots;
    }

    public boolean isParkingFloorFull(){
        
        BitSet fullBitSet = new BitSet();
        int bitIndex = 0;

        for(Map.Entry<ParkingSpotType, Deque<ParkingSpot>> entry : parkingSpots.entrySet()){

            if(entry.getValue().size() != 0){
                break;
            }
            
            fullBitSet.set(bitIndex++);
        }

        return fullBitSet.cardinality() == parkingSpots.size();
    }

    public boolean canParkVehicle(VehicleType vehicleType){
        return canParkVehicle(getParkingSpotType(vehicleType));
    }

    private boolean canParkVehicle(ParkingSpotType parkingSpotType){
        return parkingSpots.get(parkingSpotType).size() > 0;
    }

    public synchronized ParkingSpot parkVehicle(VehicleType vehicleType){

        if(!canParkVehicle(vehicleType)){
            return null;
        }
        
        ParkingSpotType parkingSpotType = getParkingSpotType(vehicleType);
        ParkingSpot parkingSpot = parkingSpots.get(parkingSpotType).poll();

        usedParkingSpots.put(parkingSpot.getId(), parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot unParkVehicle(String parkingSpotId){

        ParkingSpot parkingSpot = usedParkingSpots.remove(parkingSpotId);
        if(parkingSpot == null){
            return null;
        }
        
        parkingSpot.freeParkingSpot();
        parkingSpots.get(parkingSpot.getParkingSpotType()).addFirst(parkingSpot);
        return parkingSpot;
    }


    public static ParkingSpotType getParkingSpotType(VehicleType vehicleType){
        
        switch (vehicleType) {
            case TWO_WHEELER:
                return ParkingSpotType.TWO_WHEELER;

            case FOUR_WHEELER:
                return ParkingSpotType.FOUR_WHEELER;

            case LARGE:
                return ParkingSpotType.LARGE;

            case ABLED:
                return ParkingSpotType.ABLED;
        }

        throw new IllegalArgumentException("Invalid vehicle type");
    }
}
