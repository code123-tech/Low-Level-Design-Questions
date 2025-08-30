package Questions.TrafficSignalSystem.TrafficLightStates.Impl;

import Questions.TrafficSignalSystem.TrafficLightStates.ITrafficLightState;
import Questions.TrafficSignalSystem.TrafficLightStates.TrafficLightContext;
import Questions.TrafficSignalSystem.enums.LightColor;

public class GreenLightState implements ITrafficLightState{

    @Override
    public void handleChange(TrafficLightContext context) {
        
        context.setCurrentColor(LightColor.GREEN);
        context.setNextState(new YellowLightState());
    }

}
