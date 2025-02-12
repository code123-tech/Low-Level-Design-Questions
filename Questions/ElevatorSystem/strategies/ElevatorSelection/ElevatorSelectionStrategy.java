package Questions.ElevatorSystem.strategies.ElevatorSelection;

import java.util.ArrayList;
import java.util.List;

import Questions.ElevatorSystem.ElevatorCarController;
import Questions.ElevatorSystem.enums.Direction;

public abstract class ElevatorSelectionStrategy {

    protected List<ElevatorCarController> elevatorCarControllers = new ArrayList<ElevatorCarController>();

    abstract public int selectElevator(int floor, Direction direction);
}
