package Flyweight;

public class LabelType {
    private final String color;
    private final String shape;

    public LabelType(String color, String shape) {
        this.color = color;
        this.shape = shape;
    }

    public void draw(Object canvas, int x, int y) {
        // Drawing logic using color and shape at (x, y) on the canvas
        System.out.println("Drawing " + shape + " in color " + color + " at (" + x + ", " + y + ")");
    }
} 