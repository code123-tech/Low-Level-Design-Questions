package Questions.Word_Processor.models.Commands;

import Questions.Word_Processor.models.Character;
import Questions.Word_Processor.models.Document;
import Questions.Word_Processor.models.Formatting;
import Questions.Word_Processor.models.TextRun;

public class InsertTextCommand implements Command{

    String text;
    int position;
    Formatting formatting;
    Document document;
    int paragraphIndex;
    int textRunIndex;

    public InsertTextCommand(String text, int position, Formatting formatting, Document document) {
        this.text = text;
        this.position = position;
        this.formatting = formatting;
        this.document = document;
        this.paragraphIndex = 0; 
        this.textRunIndex = position; 
    }

    @Override
    public void execute(){

        TextRun run = new TextRun(formatting);
        for (char c : text.toCharArray()) {
            run.addCharacter(new Character(c, formatting));
        }
        document.paragraphs.get(paragraphIndex).addTextRun(run, textRunIndex);
    }

    @Override
    public void undo() {
        document.paragraphs.get(paragraphIndex).removeTextRun(textRunIndex, 1);
    }
    
}
