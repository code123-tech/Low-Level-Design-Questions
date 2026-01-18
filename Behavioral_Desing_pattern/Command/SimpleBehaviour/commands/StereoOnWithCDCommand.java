package Behavioral_Desing_pattern.Command.SimpleBehaviour.commands;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.vendors.IStereo;

public class StereoOnWithCDCommand implements Command{

    private final IStereo stereo;

    public StereoOnWithCDCommand(IStereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }

}
