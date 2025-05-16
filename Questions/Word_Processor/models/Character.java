package Questions.Word_Processor.models;

public class Character {

    char value;
    Formatting charFormatting;

    public Character(char value, Formatting charFormatting) {
        this.value = value;
        this.charFormatting = charFormatting;
    }

    @Override
    public String toString() {
        return value + "(" + charFormatting + ")";
    }

}
