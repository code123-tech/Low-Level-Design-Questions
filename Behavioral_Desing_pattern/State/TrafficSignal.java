package Behavioral_Desing_pattern.State;

import Behavioral_Desing_pattern.State.states.RedState;
import Behavioral_Desing_pattern.State.states.State;

public class TrafficSignal {
    
    private State currentState;

    public TrafficSignal() {
        this.currentState = new RedState();
        this.currentState.setContext(this);
        this.currentState.onEnter();
    }

    public void next() {
        currentState.next();
    }

    public String current() {
        return currentState.name();
    }

    public void transitionTo(State next) {
        currentState.onExit();
        currentState = next;
        currentState.setContext(this);
        currentState.onEnter();
    }
}


