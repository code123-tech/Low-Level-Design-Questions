package Questions.TrafficSignalSystem.Circle;

import java.util.Map;

import Questions.TrafficSignalSystem.Circle.Impl.NorthSouthGreenState;
import Questions.TrafficSignalSystem.TrafficLightStates.TrafficLightContext;
import Questions.TrafficSignalSystem.enums.TrafficSignalDirection;

public class CircleContext implements Runnable{

    private final int id;
    private final Map<TrafficSignalDirection, TrafficLightContext> trafficSignals;
    private final long greenLightDuration;
    private final long yellowLightDuration;

    private ICircleState currentState;
    private volatile boolean running = true;
    

    public CircleContext(int id, Map<TrafficSignalDirection, TrafficLightContext> trafficSignals, long greenLightDuration, long yellowLightDuration) {
        this.id = id;
        this.trafficSignals = trafficSignals;
        this.greenLightDuration = greenLightDuration;
        this.yellowLightDuration = yellowLightDuration;

        this.currentState = new NorthSouthGreenState();
    }

    public int getId() {
        return this.id;
    }

    public Map<TrafficSignalDirection, TrafficLightContext> getTrafficSignals() {
        return this.trafficSignals;
    }

    public long getGreenLightDuration() {
        return this.greenLightDuration;
    }

    public long getYellowLightDuration() {
        return this.yellowLightDuration;
    }

    public void setState(ICircleState state){
        this.currentState = state;
    }    

    public void state(){
        new Thread(this).start();
    }

    public void stop(){
        this.running = false;
    }

    @Override
    public void run() {

        while (this.running){
            try{
                this.currentState.handleChange(this);
            } catch (InterruptedException ex){
                Thread.currentThread().interrupt();
                System.out.println("Circle: " + this.id + " interrupted");
                this.running = false;
            }
        }
    }

    public TrafficLightContext getTrafficLight(TrafficSignalDirection direction){
        return this.trafficSignals.get(direction);
    }

}
