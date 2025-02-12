package Questions.ElevatorSystem.models;

import Questions.ElevatorSystem.enums.Direction;

public class PendingRequests {

    private int floor;
    private Direction direction;

    public PendingRequests(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}
