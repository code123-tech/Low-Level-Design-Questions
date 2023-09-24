package Questions.WebScrapper;

import Questions.WebScrapper.Worker.Consumer;
import Questions.WebScrapper.Worker.Producer;
import Questions.WebScrapper.service.Impl.QueueServiceImpl;
import Questions.WebScrapper.service.QueueService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        QueueService queueService = new QueueServiceImpl(5);
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executor.execute(new Producer(queueService));
        executor.execute(new Consumer(queueService));
        executor.shutdown();
    }
}
