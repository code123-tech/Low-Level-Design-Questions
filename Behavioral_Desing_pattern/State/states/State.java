package Behavioral_Desing_pattern.State.states;

import Behavioral_Desing_pattern.State.TrafficSignal;

public interface State {
    void setContext(TrafficSignal signal);
    void onEnter();
    void onExit();
    void next();
    String name();
}


