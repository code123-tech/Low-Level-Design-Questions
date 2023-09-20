package Questions.MultiThreadedLogger.Services;

import Questions.MultiThreadedLogger.models.PrintableMessage;

import java.util.List;

public interface QueueService {
    void publish(List<PrintableMessage> messages) throws InterruptedException;
    PrintableMessage consume() throws InterruptedException;
}
