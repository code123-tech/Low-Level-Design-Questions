package Behavioral_Desing_pattern.Command;

import Behavioral_Desing_pattern.Command.SimpleBehaviour.commands.Command;
import Behavioral_Desing_pattern.Command.SimpleBehaviour.commands.NoCommand;

public class RemoteControl {

    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;

    public RemoteControl(int size) {
        onCommands = new Command[size];
        offCommands = new Command[size];

        Command noCommand = new NoCommand();
        for (int i = 0; i < size; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPressed() {
        undoCommand.undo();
    }

    public String toString() {
        StringBuilder stringBuff = new StringBuilder();
        stringBuff.append("\n----- Remote Control -----\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot ").append(i).append("] ")
                    .append(onCommands[i].getClass().getSimpleName()).append("    ")
                    .append(offCommands[i].getClass().getSimpleName()).append("\n");
        }
        stringBuff.append("[undo] ").append(undoCommand.getClass().getSimpleName()).append("\n");

        return stringBuff.toString();
    }

}
