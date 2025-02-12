package Questions.ElevatorSystem;

import java.util.List;

import Questions.ElevatorSystem.models.Floor;
import Questions.ElevatorSystem.strategies.ElevatorControl.ElevatorControlStrategy;
import Questions.ElevatorSystem.strategies.ElevatorSelection.ElevatorSelectionStrategy;

import java.util.ArrayList;

public class ElevatorSystem {

    private List<ElevatorCarController> elevatorCarControllers = new ArrayList<ElevatorCarController>();
    public static ElevatorControlStrategy elevatorControlStrategy;
    public static ElevatorSelectionStrategy elevatorSelectionStrategy;
    public List<Floor> floors = new ArrayList<Floor>();

    public static ElevatorSystem INSTANCE = new ElevatorSystem();

    private ElevatorSystem() {
    }

    public void addElevator(ElevatorCarController elevatorCarController) {
        elevatorCarControllers.add(elevatorCarController);
    }

    public void removeElevator(ElevatorCarController elevatorCarController) {
        elevatorCarControllers.remove(elevatorCarController);
    }



    public List<ElevatorCarController> getElevatorCarControllers() {
        return elevatorCarControllers;
    }

    public List<Floor> getFloors() {
        return floors;
    }
    
    public static void setElevatorControlStrategy(ElevatorControlStrategy elevatorControlStrategy) {
        ElevatorSystem.elevatorControlStrategy = elevatorControlStrategy;
    }

    public static void setElevatorSelectionStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy) {
        ElevatorSystem.elevatorSelectionStrategy = elevatorSelectionStrategy;
    }

    public void addFloor(Floor floor){
        floors.add(floor);
    }
}
