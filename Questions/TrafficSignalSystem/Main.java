package Questions.TrafficSignalSystem;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        
        TrafficSignalController controller = TrafficSignalController.getInstance();

        controller.addCircle(1, 500, 200);
        controller.addCircle(2, 700, 150);

        controller.startTrafficSignal();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        controller.stopTrafficSignal();

    }
}
