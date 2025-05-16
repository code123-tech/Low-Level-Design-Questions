package Questions.Word_Processor.models.Commands;

import Questions.Word_Processor.models.Document;
import Questions.Word_Processor.models.Formatting;
import Questions.Word_Processor.models.TextRun;

public class ApplyFormattingCommand implements Command {

    int start, end;
    Formatting oldFormatting;
    Formatting newFormatting;
    Document document;
    int paragraphIndex;

    public ApplyFormattingCommand(int start, int end, Formatting newFormatting, Document document){
        this.start = start;
        this.end = end;
        this.newFormatting = newFormatting;
        this.document = document;
        this.paragraphIndex = 0;
    }

    @Override
    public void execute(){
        TextRun textRun = document.paragraphs.get(paragraphIndex).textRuns.get(start);
        oldFormatting = textRun.textFormatting;
        textRun.textFormatting = newFormatting;
    }


    @Override
    public void undo(){
        TextRun textRun = document.paragraphs.get(paragraphIndex).textRuns.get(start);
        textRun.textFormatting = oldFormatting;
    }
}
