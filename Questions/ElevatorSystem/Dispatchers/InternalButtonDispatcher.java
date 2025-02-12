package Questions.ElevatorSystem.Dispatchers;

import Questions.ElevatorSystem.ElevatorCarController;
import Questions.ElevatorSystem.ElevatorSystem;
import Questions.ElevatorSystem.enums.Direction;

public class InternalButtonDispatcher {

    public void submitRequest(int floor, int elevatorId, Direction direction){
        
        for(ElevatorCarController elevatorCarController : ElevatorSystem.INSTANCE.getElevatorCarControllers()){
            if(elevatorCarController.getId() == elevatorId){
                elevatorCarController.acceptRequest(floor, direction);
            }
        }
    }
}
