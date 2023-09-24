package Questions.WebScrapper.Worker;


import Questions.WebScrapper.Utils.Data;
import Questions.WebScrapper.model.Request;
import Questions.WebScrapper.service.QueueService;

public class Producer implements Runnable {
    private final QueueService queueService;

    public Producer(QueueService queueService) {
        this.queueService = queueService;
    }

    @Override
    public void run() {
        for (Request request : Data.requests) {
            try {
                this.queueService.publish(request);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
