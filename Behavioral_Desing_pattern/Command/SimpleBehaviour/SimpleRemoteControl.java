package Behavioral_Desing_pattern.Command.SimpleBehaviour;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.commands.Command;

public class SimpleRemoteControl {

    Command slot;

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }

}
