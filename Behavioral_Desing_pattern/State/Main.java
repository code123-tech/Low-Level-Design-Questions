package Behavioral_Desing_pattern.State;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("----- Traffic Signal with State Pattern -----");
        TrafficSignal signal = new TrafficSignal();
        for (int i = 0; i < 6; i++) {
            System.out.println("Current: " + signal.current());
            signal.next();
        }
    }
}


