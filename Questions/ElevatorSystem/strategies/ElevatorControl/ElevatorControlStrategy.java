package Questions.ElevatorSystem.strategies.ElevatorControl;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Questions.ElevatorSystem.ElevatorCarController;
import Questions.ElevatorSystem.ElevatorSystem;
import Questions.ElevatorSystem.models.PendingRequests;

public abstract class ElevatorControlStrategy {
    
    private Queue<PendingRequests> pendingRequests = new LinkedList<PendingRequests>(); 
    private List<ElevatorCarController> elevatorCarControllers = ElevatorSystem.INSTANCE.getElevatorCarControllers();

    public List<ElevatorCarController> getElevatorCarControllers() {
        return elevatorCarControllers;
    }

    public Queue<PendingRequests> getPendingRequests() {
        return pendingRequests;
    }

    public void setPendingRequests(Queue<PendingRequests> pendingRequests) {
        this.pendingRequests = pendingRequests;
    }

    abstract public void moveElevator(ElevatorCarController elevatorCarController);
}
