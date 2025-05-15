package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class LabelTypeFactory {
    private Map<String, LabelType> labelTypeMap = new HashMap<>();

    public LabelType getLabelType(String color, String shape) {
        String key = color + ":" + shape;
        if (!labelTypeMap.containsKey(key)) {
            labelTypeMap.put(key, new LabelType(color, shape));
        }
        return labelTypeMap.get(key);
    }
} 