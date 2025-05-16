package Questions.Word_Processor.models;

import java.util.Stack;

import Questions.Word_Processor.models.Commands.Command;

public class CommandHistory {

    public Stack<Command> undoStack;
    public Stack<Command> redoStack;

    public CommandHistory() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void executeCommand(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo(){

        if(undoStack.empty()){
            return;
        }

        Command command = undoStack.pop();
        command.undo();
        redoStack.push(command);
    }

    public void redo(){

        if(redoStack.empty()){
            return;
        }

        Command command = redoStack.pop();
        command.execute();
        undoStack.push(command);
    }
}
