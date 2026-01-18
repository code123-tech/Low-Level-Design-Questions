package Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.Impl;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.IStereo;

public class Stereo implements IStereo {

    private final String location;

    public Stereo(String location) {
        this.location = location;
    }

    @Override
    public void on() {
        System.out.printf("%s Stereo is On\n", this.location);
    }

    @Override
    public void off() {
        System.out.printf("%s Stereo is Off\n", this.location);
    }

    @Override
    public void setCD() {
        System.out.printf("%s Stereo is set for CD input\n", this.location);
    }

    @Override
    public void setDVD() {
        System.out.printf("%s Stereo is set for DVD input\n", this.location);
    }

    @Override
    public void setRadio() {
        System.out.printf("%s Stereo is set for Radio input\n", this.location);
    }

    @Override
    public void setVolume(int volume) {
        System.out.printf("%s Stereo volume set to %d\n", this.location, volume);
    }
}
