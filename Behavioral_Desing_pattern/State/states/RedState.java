package Behavioral_Desing_pattern.State.states;

import Behavioral_Desing_pattern.State.TrafficSignal;

public class RedState implements State {
    
    private TrafficSignal signal;

    @Override
    public void setContext(TrafficSignal signal) {
        this.signal = signal;
    }
    @Override
    public void onEnter() {
        System.out.println("RED: Stop");
    }

    @Override
    public void onExit() {
        System.out.println("Leaving RED");
    }

    @Override
    public void next() {
        signal.transitionTo(new GreenState());
    }

    @Override
    public String name() {
        return "RED";
    }
}


