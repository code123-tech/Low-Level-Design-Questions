package Questions.Word_Processor.models;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {

    public List<TextRun> textRuns;
    Formatting paragraphFormatting;

    Paragraph(Formatting paragraphFormatting) {
        this.textRuns = new ArrayList<>();
        this.paragraphFormatting = paragraphFormatting;
    }

    public void addTextRun(TextRun textRun, int position) {
        if (position < 0 || position > textRuns.size()) {
            position = textRuns.size();
        }
        textRuns.add(position, textRun);
    }

    public void removeTextRun(int position, int length){
        for (int i = 0; i < length && position < textRuns.size(); i++) {
            textRuns.remove(position);
        }
    }

    @Override
    public String toString() {
        return "Paragraph{textRuns=" + textRuns + ", formatting=" + paragraphFormatting + "}";
    }

}
