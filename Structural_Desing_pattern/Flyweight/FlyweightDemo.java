package Flyweight;

public class FlyweightDemo {
    public static void main(String[] args) {
        GoogleMap map = new GoogleMap();
        map.plotLabel(10, 20, "Circle", "Red");
        map.plotLabel(15, 25, "Circle", "Red");
        map.plotLabel(30, 40, "Square", "Blue");
        map.plotLabel(50, 60, "Circle", "Red");
        map.plotLabel(70, 80, "Square", "Blue");
        map.draw(null); // Passing null as canvas for demo
    }
} 