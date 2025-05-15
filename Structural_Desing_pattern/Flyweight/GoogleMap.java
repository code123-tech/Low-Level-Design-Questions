package Flyweight;

import java.util.ArrayList;
import java.util.List;

public class GoogleMap {
    private List<Label> labels = new ArrayList<>();
    private LabelTypeFactory labelTypeFactory = new LabelTypeFactory();

    public void plotLabel(int x, int y, String shape, String color) {
        LabelType labelType = labelTypeFactory.getLabelType(color, shape);
        Label label = new Label(x, y, labelType);
        labels.add(label);
    }

    public void draw(Object canvas) {
        for (Label label : labels) {
            label.draw(canvas);
        }
    }
} 