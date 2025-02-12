package Questions.ElevatorSystem;

import Questions.ElevatorSystem.enums.Direction;
import Questions.ElevatorSystem.models.ElevatorCar;

public class ElevatorCarController {
    
    private int id;
    private ElevatorCar elevatorCar;

    public ElevatorCarController(int id){
        this.id = id;
        this.elevatorCar = new ElevatorCar(id);
    }

    public int getId() {
        return id;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void acceptRequest(int floor, Direction dir){

    
        controlCar();
    }

    private void controlCar(){

        System.out.println("Elevator moving..");
    }
}
