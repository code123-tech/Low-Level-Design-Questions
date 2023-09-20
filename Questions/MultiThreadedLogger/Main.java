package Questions.MultiThreadedLogger;

import Questions.MultiThreadedLogger.Services.Impl.QueueServiceImpl;
import Questions.MultiThreadedLogger.Services.QueueService;
import Questions.MultiThreadedLogger.Threads.Consumer;
import Questions.MultiThreadedLogger.Threads.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        QueueService queueService = new QueueServiceImpl(100);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Producer(queueService));
        executorService.execute(new Producer(queueService));
        executorService.execute(new Consumer(queueService));
        executorService.shutdown();
    }

}
