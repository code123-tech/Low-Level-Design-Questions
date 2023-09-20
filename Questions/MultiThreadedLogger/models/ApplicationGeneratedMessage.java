package Questions.MultiThreadedLogger.models;

import Questions.MultiThreadedLogger.enums.LoggingMediums;

import java.time.Instant;
import java.util.List;

public class ApplicationGeneratedMessage {
    private String message;
    private List<LoggingMediums> mediums; // An application level message can support multiple logging mediums at a time.
    private Thread currentThread;
    private Instant time;

    public ApplicationGeneratedMessage(String message, List<LoggingMediums> mediums){
        this.mediums = mediums;
        this.message = message;
        this.currentThread = Thread.currentThread();
        this.time = Instant.now();
    }

    public String getMessage() {
        return message;
    }

    public List<LoggingMediums> getMediums() {
        return mediums;
    }

    public Thread getCurrentThread() {
        return currentThread;
    }

    public Instant getTime() {
        return time;
    }
}
