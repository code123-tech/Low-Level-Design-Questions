package Questions.Word_Processor.models.Commands;

public interface Command {

    void execute();
    void undo();

}
