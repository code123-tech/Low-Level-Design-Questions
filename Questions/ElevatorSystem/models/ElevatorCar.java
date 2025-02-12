package Questions.ElevatorSystem.models;

import Questions.ElevatorSystem.enums.Direction;
import Questions.ElevatorSystem.enums.ElevatorStatus;

public class ElevatorCar {

    private int elevatorId;
    private Display display;
    private ElevatorStatus status;
    private InternalButton internalButton;
    private int currentFloor;
    private Direction direction;
    
    public ElevatorCar(int elevatorId){
        this.elevatorId = elevatorId;
        this.status = ElevatorStatus.WORKING;
        this.display = new Display();
        this.internalButton = new InternalButton();
        this.direction = Direction.IDLE;
        this.currentFloor = 0;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public Display getDisplay() {
        return display;
    }

    public ElevatorStatus getStatus() {
        return status;
    }

    public InternalButton getInternalButton() {
        return internalButton;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }


    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void move(int destFloor, Direction dir){

        System.out.println("Elevator " + elevatorId + " is moving " + dir);
        System.out.println("Elevator " + elevatorId + " stops at floor " + destFloor);

        setDisplay();
    }


    private void setDisplay(){
        display.setFloorNumber(currentFloor);
        display.setDirection(direction);
    }

    public void pressButton(int floor){

        Direction dir = Direction.IDLE;
        if(floor > currentFloor){
            dir = Direction.UP;
        } else if(floor < currentFloor){
            dir = Direction.DOWN;
        }

        internalButton.pressButton(floor, elevatorId, dir);
    }
}
