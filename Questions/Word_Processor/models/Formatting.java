package Questions.Word_Processor.models;

import Questions.Word_Processor.enums.AlignmentType;

public class Formatting {

    boolean isBold;
    boolean isItalic;
    int fontSize;
    String fontFamily;
    AlignmentType alignmentType;

    public Formatting(boolean isBold, boolean isItalic, int fontSize, String fontFamily, AlignmentType alignmentType) {
        this.isBold = isBold;
        this.isItalic = isItalic;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.alignmentType = alignmentType;
    }

    @Override
    public String toString() {

        return "Formatting{bold=" + isBold + ", italic=" + isItalic + ", fontSize=" + fontSize + 
               ", fontFamily=" + fontFamily + ", alignment=" + alignmentType + "}";
    }

}
