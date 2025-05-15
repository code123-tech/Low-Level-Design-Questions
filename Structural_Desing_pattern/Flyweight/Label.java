package Flyweight;

public class Label {
    private final int x;
    private final int y;
    private final LabelType labelType;

    public Label(int x, int y, LabelType labelType) {
        this.x = x;
        this.y = y;
        this.labelType = labelType;
    }

    public void draw(Object canvas) {
        labelType.draw(canvas, x, y);
    }
} 