package Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors;

public interface ICeilingFan {
    int HIGH = 3;
    int MEDIUM = 2;
    int LOW = 1;
    int OFF = 0;
    
    void high();
    void medium();
    void low();
    void off();
    int getSpeed();
}
