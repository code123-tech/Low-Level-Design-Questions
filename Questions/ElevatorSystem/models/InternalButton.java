package Questions.ElevatorSystem.models;

import java.util.ArrayList;
import java.util.List;

import Questions.ElevatorSystem.Dispatchers.InternalButtonDispatcher;
import Questions.ElevatorSystem.enums.Direction;

public class InternalButton {

    private InternalButtonDispatcher internalButtonDispatcher;

    private List<Integer> floors = new ArrayList<Integer>();

    public InternalButton(){
        internalButtonDispatcher = new InternalButtonDispatcher();
    }

    public void pressButton(int floor, int elevatorId, Direction direction){

        floors.add(floor);
        System.out.println("Pressed floor " + floor + " from elevator " + elevatorId);
        internalButtonDispatcher.submitRequest(floor, elevatorId, direction);
    }
}
