package Behavioral_Desing_pattern.Command.SimpleBehaviour.commands;

public class NoCommand implements Command {

    @Override
    public void execute() {
        System.out.println("No command assigned to this slot.");
    }

    @Override
    public void undo() {
        // Do nothing
    }
}
