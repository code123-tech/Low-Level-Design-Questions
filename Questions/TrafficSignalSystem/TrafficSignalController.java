package Questions.TrafficSignalSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import Questions.TrafficSignalSystem.Circle.CircleContext;
import Questions.TrafficSignalSystem.TrafficLightStates.TrafficLightContext;
import Questions.TrafficSignalSystem.enums.TrafficSignalDirection;

public class TrafficSignalController {

    private static final TrafficSignalController INSTANCE = new TrafficSignalController();
    private final List<CircleContext> circles = new ArrayList<>();
    private ExecutorService executorService;

    private TrafficSignalController(){}

    public static TrafficSignalController getInstance(){
        return INSTANCE;
    }

    public void addCircle(int circleId, long greenLightDuration, long yellowLightDuration){
        
        Map<TrafficSignalDirection, TrafficLightContext> trafficSignals = new HashMap<>();
        trafficSignals.put(TrafficSignalDirection.NORTH, new TrafficLightContext(TrafficSignalDirection.NORTH, circleId));
        trafficSignals.put(TrafficSignalDirection.SOUTH, new TrafficLightContext(TrafficSignalDirection.SOUTH, circleId));
        trafficSignals.put(TrafficSignalDirection.EAST, new TrafficLightContext(TrafficSignalDirection.EAST, circleId));
        trafficSignals.put(TrafficSignalDirection.WEST, new TrafficLightContext(TrafficSignalDirection.WEST, circleId));
        
        CircleContext circle = new CircleContext(circleId, trafficSignals, greenLightDuration, yellowLightDuration);
        this.circles.add(circle);
    }

    public void startTrafficSignal(){

        if(circles.isEmpty()){
            System.out.println("No circles to start traffic signal");
            return;
        }

        System.out.println("Starting traffic signal...");
        this.executorService = Executors.newFixedThreadPool(this.circles.size());

        for(CircleContext circle : this.circles){
            this.executorService.submit(circle);
        }
    }

    public void stopTrafficSignal(){

        System.out.println("Stopping traffic signal...");
        for(CircleContext circle : this.circles){
            circle.stop();
        }
        this.executorService.shutdown();

        try{
            if(!this.executorService.awaitTermination(5, TimeUnit.SECONDS)){
                this.executorService.shutdownNow();
            }
        } catch (InterruptedException ex){
            this.executorService.shutdownNow();
        }

        System.out.println("Traffic signal stopped");
        
    }
    
}
