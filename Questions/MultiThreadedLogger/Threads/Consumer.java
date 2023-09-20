package Questions.MultiThreadedLogger.Threads;

import Questions.MultiThreadedLogger.Services.QueueService;
import Questions.MultiThreadedLogger.factory.InternalLoggerFactory;
import Questions.MultiThreadedLogger.logger.InternalLogger;
import Questions.MultiThreadedLogger.models.PrintableMessage;

public class Consumer implements Runnable{
    private QueueService queueService;
    public Consumer(QueueService queueService){
        this.queueService = queueService;
    }

    @Override
    public void run() {
        while (true){
            try{
                PrintableMessage message = this.queueService.consume();
                InternalLogger logger = InternalLoggerFactory.getLoggerInstance(message.getMedium());
                logger.log(message);

                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
