package Behavioral_Desing_pattern.State.states;

import Behavioral_Desing_pattern.State.TrafficSignal;

public class GreenState implements State {
    
    private TrafficSignal signal;

    @Override
    public void setContext(TrafficSignal signal) {
        this.signal = signal;
    }
    @Override
    public void onEnter() {
        System.out.println("GREEN: Go");
    }

    @Override
    public void onExit() {
        System.out.println("Leaving GREEN");
    }

    @Override
    public void next() {
        signal.transitionTo(new YellowState());
    }

    @Override
    public String name() {
        return "GREEN";
    }
}


