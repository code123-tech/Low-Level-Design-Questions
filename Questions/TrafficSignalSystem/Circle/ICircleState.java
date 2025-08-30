package Questions.TrafficSignalSystem.Circle;

public interface ICircleState {

    void handleChange(CircleContext context) throws InterruptedException;

}
