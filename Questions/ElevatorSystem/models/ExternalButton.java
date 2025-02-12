package Questions.ElevatorSystem.models;

import Questions.ElevatorSystem.Dispatchers.ExternalButtonDispatcher;
import Questions.ElevatorSystem.enums.Direction;

public class ExternalButton {

    private ExternalButtonDispatcher externalButtonDispatcher;
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public void pressButton(int floor, Direction direction){

        this.direction = direction;
        System.out.println("Pressed " + direction + " from floor " + floor);
        externalButtonDispatcher.submitRequest(floor, direction);
    }
}
