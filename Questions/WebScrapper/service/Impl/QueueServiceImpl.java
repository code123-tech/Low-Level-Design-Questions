package Questions.WebScrapper.service.Impl;


import Questions.WebScrapper.Utils.Data;
import Questions.WebScrapper.constants.ApplicationConstants;
import Questions.WebScrapper.model.Request;
import Questions.WebScrapper.model.Response;
import Questions.WebScrapper.service.QueueService;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueServiceImpl implements QueueService {
    private ArrayBlockingQueue<Response> queue;
    private int capacity;

    public QueueServiceImpl(int capacity){
        this.capacity = Math.max(capacity, ApplicationConstants.DEFAULT_CAPACITY);
        this.queue = new ArrayBlockingQueue<>(this.capacity);
    }

    @Override
    public void publish(Request request) throws InterruptedException {
        Objects.requireNonNull(request);
        this.queue.offer(Data.fetchResponse(request), ApplicationConstants.DEFAULT_PUBLISH_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    @Override
    public Response consume() throws InterruptedException {
        return this.queue.poll(ApplicationConstants.DEFAULT_CONSUMPTION_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }
}
