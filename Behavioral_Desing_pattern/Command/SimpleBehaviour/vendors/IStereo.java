package Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors;

public interface IStereo {
    void on();
    void off();
    void setCD();
    void setDVD();
    void setRadio();
    void setVolume(int volume);
}
