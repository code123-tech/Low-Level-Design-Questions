package Questions.ParkingLots.ParkingLot2.repository;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import Questions.ParkingLots.ParkingLot2.exceptions.InvalidParkingFloorException;
import Questions.ParkingLots.ParkingLot2.exceptions.InvalidParkingLotException;
import Questions.ParkingLots.ParkingLot2.model.Parking.ParkingEntryPoint;
import Questions.ParkingLots.ParkingLot2.model.Parking.ParkingExitPoint;
import Questions.ParkingLots.ParkingLot2.model.Parking.ParkingFloor;
import Questions.ParkingLots.ParkingLot2.model.Parking.ParkingLot;
import Questions.ParkingLots.ParkingLot2.model.Parking.spots.ParkingSpot;

public class ParkingLotRepository {

    public static Map<String, ParkingLot> parkingLotMap = new HashMap<>();
    public static List<ParkingLot> parkingLotList = new ArrayList<>();

    public ParkingLot addParkingLot(ParkingLot parkingLot){
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        parkingLotList.add(parkingLot);
        return parkingLot;
    }

    public ParkingLot getParkingLotById(String id){
        return parkingLotMap.get(id);
    }

    public ParkingFloor addParkingFloor(String parkingLotId, ParkingFloor parkingFloor) throws Exception{
        
        ParkingLot parkingLot = getParkingLotById(parkingLotId);
        if(parkingLot == null){
            throw new InvalidParkingLotException("Parking lot not found");
        }
        
        Optional<ParkingFloor> parkingFloorOptional = parkingLot.getParkingFloors().stream()
                                                        .filter(pFloor -> pFloor.getId().equalsIgnoreCase(parkingFloor.getId()))
                                                        .findFirst();

        if(parkingFloorOptional.isPresent()){
            return parkingFloorOptional.get();
        }

        parkingLot.getParkingFloors().add(parkingFloor);
        return parkingFloor;
    }

    public ParkingSpot addParkingSpot(String parkingLotId, String parkingFloorId, ParkingSpot parkingSpot) throws Exception{
        
        ParkingLot parkingLot = getParkingLotById(parkingLotId);
        if(parkingLot == null){
            throw new InvalidParkingLotException("Parking lot not found");
        }
        
        Optional<ParkingFloor> parkingFloorOptional = parkingLot.getParkingFloors().stream()
                                                        .filter(pFloor -> pFloor.getId().equalsIgnoreCase(parkingFloorId))
                                                        .findFirst();

        if(!parkingFloorOptional.isPresent()){
            throw new InvalidParkingFloorException("Parking floor is invalid");
        }

        ParkingFloor parkingFloor = parkingFloorOptional.get();
        
        Deque<ParkingSpot> parkingSpots =parkingFloor.getParkingSpots().get(parkingSpot.getParkingSpotType());
        Optional<ParkingSpot> parkingSpotOptional = parkingFloor.getParkingSpots().get(parkingSpot.getParkingSpotType())
                                                        .stream().filter(pSpot -> pSpot.getId().equalsIgnoreCase(parkingSpot.getId()))
                                                        .findFirst();

        if(parkingSpotOptional.isPresent()){
            return parkingSpotOptional.get();
        }
        
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public ParkingEntryPoint addEntryPanel(String parkingLotId, ParkingEntryPoint parkingEntryPoint)
            throws InvalidParkingLotException {

        ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
        if (parkingLot == null)
            throw new InvalidParkingLotException("Invalid parking lot");

        Optional<ParkingEntryPoint> ePanel = parkingLotMap.get(parkingLotId)
                        .getParkingEntryPoints().stream().filter(ep -> ep.getId().equalsIgnoreCase(parkingEntryPoint.getId()))
                        .findFirst();

        if (ePanel.isPresent())
            return parkingEntryPoint;

        parkingLotMap.get(parkingLotId).getParkingEntryPoints().add(parkingEntryPoint);
        return parkingEntryPoint;
    }

    public ParkingExitPoint addExitPanel(String parkingLotId, ParkingExitPoint parkingExitPoint)
            throws InvalidParkingLotException {

        ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
        if (parkingLot == null)
            throw new InvalidParkingLotException("Invalid parking lot");

        Optional<ParkingExitPoint> ePanel = parkingLotMap.get(parkingLotId)
                        .getParkingExitPoints().stream().filter(ep -> ep.getId().equalsIgnoreCase(parkingExitPoint.getId()))
                        .findFirst();
 
        if (ePanel.isPresent())
            return parkingExitPoint;

        parkingLotMap.get(parkingLotId).getParkingExitPoints().add(parkingExitPoint);
        return parkingExitPoint;
    }
}
