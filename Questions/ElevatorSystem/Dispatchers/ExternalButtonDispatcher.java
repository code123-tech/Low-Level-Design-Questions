package Questions.ElevatorSystem.Dispatchers;

import Questions.ElevatorSystem.ElevatorCarController;
import Questions.ElevatorSystem.ElevatorSystem;
import Questions.ElevatorSystem.enums.Direction;

public class ExternalButtonDispatcher {

    public static ExternalButtonDispatcher INSTANCE = new ExternalButtonDispatcher();

    private ExternalButtonDispatcher(){

    }

    public void submitRequest(int floor, Direction direction){
        
        int elevatorId = ElevatorSystem.elevatorSelectionStrategy.selectElevator(floor, direction);
        System.out.println("Selected elevator: " + elevatorId);
        
        for(ElevatorCarController elevatorCarController : ElevatorSystem.INSTANCE.getElevatorCarControllers()){
            if(elevatorCarController.getId() == elevatorId){
                elevatorCarController.acceptRequest(floor, direction);
            }
        }
    }
}
