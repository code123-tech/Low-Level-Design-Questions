package Questions.Word_Processor;

import Questions.Word_Processor.models.Document;
import Questions.Word_Processor.models.DocumentManager;
import Questions.Word_Processor.models.Formatting;
import Questions.Word_Processor.models.Commands.ApplyFormattingCommand;
import Questions.Word_Processor.models.Commands.Command;
import Questions.Word_Processor.models.Commands.InsertTextCommand;

public class Editor {

    public DocumentManager docManager;

    public Editor(DocumentManager docManager){
        this.docManager = docManager;
    }

    public void insertText(String text, int position, Formatting formatting){

        Document document = docManager.getActiveDocument();
        if(document == null){
            System.out.println("No active document.");
            return;
        }

        Command insertTextCommand = new InsertTextCommand(text, position, formatting, document);
        document.commandHistory.executeCommand(insertTextCommand);
    }

    public void applyFormatting(Formatting formatting, int start, int end){
        
        Document document = docManager.getActiveDocument();
        if(document == null){
            System.out.println("No active document.");
            return;
        }

        Command applyFormattingCommand = new ApplyFormattingCommand(start, end, formatting, document);
        document.commandHistory.executeCommand(applyFormattingCommand);
    }

    public void undo(){

        Document document = docManager.getActiveDocument();
        if(document != null){
            document.commandHistory.undo();
        }
    }

    public void redo(){

        Document document = docManager.getActiveDocument();
        if(document != null){
            document.commandHistory.redo();
        }
    }

    public void switchDocument(String id){
        docManager.switchToDocument(id);
    }

}
