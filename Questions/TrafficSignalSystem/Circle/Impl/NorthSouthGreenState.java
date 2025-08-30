package Questions.TrafficSignalSystem.Circle.Impl;

import Questions.TrafficSignalSystem.Circle.CircleContext;
import Questions.TrafficSignalSystem.Circle.ICircleState;
import Questions.TrafficSignalSystem.enums.LightColor;
import Questions.TrafficSignalSystem.enums.TrafficSignalDirection;

public class NorthSouthGreenState implements ICircleState {

    @Override
    public void handleChange(CircleContext context) throws InterruptedException {
        
        System.out.println("Circle: " + context.getId() + " is in NorthSouthGreenState");

        context.getTrafficLight(TrafficSignalDirection.NORTH).startGreenLight();
        context.getTrafficLight(TrafficSignalDirection.SOUTH).startGreenLight();
        context.getTrafficLight(TrafficSignalDirection.EAST).setCurrentColor(LightColor.RED);
        context.getTrafficLight(TrafficSignalDirection.WEST).setCurrentColor(LightColor.RED);

        Thread.sleep(context.getGreenLightDuration());

        context.getTrafficLight(TrafficSignalDirection.NORTH).transitionToNextState();
        context.getTrafficLight(TrafficSignalDirection.SOUTH).transitionToNextState();

        Thread.sleep(context.getYellowLightDuration());

        context.getTrafficLight(TrafficSignalDirection.NORTH).transitionToNextState();
        context.getTrafficLight(TrafficSignalDirection.SOUTH).transitionToNextState();

        context.setState(new EastWestGreenState());

    }
    
}
