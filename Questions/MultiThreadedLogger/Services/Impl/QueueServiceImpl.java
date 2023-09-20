package Questions.MultiThreadedLogger.Services.Impl;

import Questions.MultiThreadedLogger.Services.QueueService;
import Questions.MultiThreadedLogger.constants.ApplicationConstants;
import Questions.MultiThreadedLogger.models.PrintableMessage;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueServiceImpl implements QueueService {
    private ArrayBlockingQueue<PrintableMessage> queue;
    private int capacity;

    public QueueServiceImpl(int capacity){
        this.capacity = Math.max(capacity, ApplicationConstants.DEFAULT_CAPACITY);
        this.queue = new ArrayBlockingQueue<>(this.capacity);
    }

    @Override
    public void publish(List<PrintableMessage> messages) throws InterruptedException {
        Objects.requireNonNull(messages);
        for(PrintableMessage printableMessage: messages){
            this.queue.offer(printableMessage, ApplicationConstants.DEFAULT_PUBLISH_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public PrintableMessage consume() throws InterruptedException {
        return this.queue.poll(ApplicationConstants.DEFAULT_CONSUMPTION_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }
}
