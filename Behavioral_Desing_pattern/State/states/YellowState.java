package Behavioral_Desing_pattern.State.states;

import Behavioral_Desing_pattern.State.TrafficSignal;

public class YellowState implements State {
    private TrafficSignal signal;

    @Override
    public void setContext(TrafficSignal signal) {
        this.signal = signal;
    }
    @Override
    public void onEnter() {
        System.out.println("YELLOW: Prepare to stop");
    }

    @Override
    public void onExit() {
        System.out.println("Leaving YELLOW");
    }

    @Override
    public void next() {
        signal.transitionTo(new RedState());
    }

    @Override
    public String name() {
        return "YELLOW";
    }
}


