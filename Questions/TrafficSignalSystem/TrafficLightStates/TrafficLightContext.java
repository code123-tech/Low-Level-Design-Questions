package Questions.TrafficSignalSystem.TrafficLightStates;

import Questions.TrafficSignalSystem.TrafficLightStates.Impl.GreenLightState;
import Questions.TrafficSignalSystem.TrafficLightStates.Impl.RedLightState;
import Questions.TrafficSignalSystem.enums.LightColor;
import Questions.TrafficSignalSystem.enums.TrafficSignalDirection;

public class TrafficLightContext {

    private final TrafficSignalDirection direction;
    private final int circleId;

    private LightColor currentColor;
    private ITrafficLightState currentState;
    private ITrafficLightState nextState;

    public TrafficLightContext(TrafficSignalDirection direction, int circleId) {
        
        this.direction = direction;
        this.circleId = circleId;
        
        this.currentState = new RedLightState();
        this.currentState.handleChange(this);
    }

    public void setCurrentColor(LightColor color){

        if(this.currentColor != color){
            this.currentColor = color;
        }
    }

    public void setNextState(ITrafficLightState state){
        this.nextState = state;
    }

    public void startGreenLight() {
        this.currentState = new GreenLightState();
        this.currentState.handleChange(this);
    }

    public void transitionToNextState() {
        this.currentState = this.nextState;
        this.currentState.handleChange(this);
    }

    public TrafficSignalDirection getTrafficSignalDirection(){
        return this.direction;
    }
    
    public int getCircleId(){
        return this.circleId;
    }

}
