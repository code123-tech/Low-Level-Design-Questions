package Questions.ElevatorSystem.models;

import Questions.ElevatorSystem.enums.Direction;

public class Display {

    private int floorNumber;
    private Direction direction;
    
    
    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
