package Questions.Word_Processor.models;

import java.util.ArrayList;
import java.util.List;

import Questions.Word_Processor.enums.AlignmentType;

public class Document {

    public String id;
    public String title;
    public List<Paragraph> paragraphs;
    public CommandHistory commandHistory;

    public Document(String id, String title) {
        this.id = id;
        this.title = title;
        this.paragraphs = new ArrayList<>();
        this.commandHistory = new CommandHistory();
        // Add a default paragraph
        this.paragraphs.add(new Paragraph(new Formatting(false, false, 12, "Arial", AlignmentType.LEFT)));
    }

    public void addParagraph() {
        paragraphs.add(new Paragraph(new Formatting(false, false, 12, "Arial", AlignmentType.LEFT)));
    }

    public void removeParagraph(int index) {
        if (index >= 0 && index < paragraphs.size()) {
            paragraphs.remove(index);
        }
    }

    public void save() {
        System.out.println("Saving document " + id + " (" + title + ")");
    }

    public void load() {
        System.out.println("Loading document " + id + " (" + title + ")");
    }

    @Override
    public String toString() {
        return "Document{id=" + id + ", title=" + title + ", paragraphs=" + paragraphs + "}";
    }

}
