package Questions.Word_Processor.models;

import java.util.ArrayList;
import java.util.List;

public class TextRun {

    List<Character> characters;
    public Formatting textFormatting;

    public TextRun(Formatting textFormatting) {
        this.characters = new ArrayList<>();
        this.textFormatting = textFormatting;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void removeCharacter(int index) {
        if (index >= 0 && index < characters.size()) {
            characters.remove(index);
        }
    }

    @Override
    public String toString() {
        return "TextRun{chars=" + characters + ", formatting=" + textFormatting + "}";
    }

}
