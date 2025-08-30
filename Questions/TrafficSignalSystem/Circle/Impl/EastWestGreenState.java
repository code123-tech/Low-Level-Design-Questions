package Questions.TrafficSignalSystem.Circle.Impl;

import Questions.TrafficSignalSystem.Circle.CircleContext;
import Questions.TrafficSignalSystem.Circle.ICircleState;
import Questions.TrafficSignalSystem.enums.LightColor;
import Questions.TrafficSignalSystem.enums.TrafficSignalDirection;

public class EastWestGreenState implements ICircleState {

    @Override
    public void handleChange(CircleContext context) throws InterruptedException {
        
        System.out.println("Circle: " + context.getId() + " is in EastWestGreenState");

        context.getTrafficLight(TrafficSignalDirection.EAST).startGreenLight();
        context.getTrafficLight(TrafficSignalDirection.WEST).startGreenLight();
        context.getTrafficLight(TrafficSignalDirection.NORTH).setCurrentColor(LightColor.RED);
        context.getTrafficLight(TrafficSignalDirection.SOUTH).setCurrentColor(LightColor.RED);

        Thread.sleep(context.getGreenLightDuration());

        context.getTrafficLight(TrafficSignalDirection.EAST).transitionToNextState();
        context.getTrafficLight(TrafficSignalDirection.WEST).transitionToNextState();

        Thread.sleep(context.getYellowLightDuration());

        context.getTrafficLight(TrafficSignalDirection.EAST).transitionToNextState();
        context.getTrafficLight(TrafficSignalDirection.WEST).transitionToNextState();

        context.setState(new NorthSouthGreenState());

    }

}
