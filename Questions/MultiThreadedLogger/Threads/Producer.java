package Questions.MultiThreadedLogger.Threads;

import Questions.MultiThreadedLogger.Services.QueueService;
import Questions.MultiThreadedLogger.enums.LoggingMediums;
import Questions.MultiThreadedLogger.logger.ApplicationGeneratedLogger;
import Questions.MultiThreadedLogger.logger.Impl.ApplicationGeneratedLoggerImpl;
import Questions.MultiThreadedLogger.models.ApplicationGeneratedMessage;

import java.util.Arrays;
import java.util.Random;

public class Producer implements Runnable{
    private QueueService queueService;
    public Producer(QueueService queueService){
        this.queueService = queueService;
    }

    @Override
    public void run() {
        while (true){
            ApplicationGeneratedLogger logger = new ApplicationGeneratedLoggerImpl(this.queueService);
            for(int i = 0; i < 100; i++){
                try{
                    logger.info(new ApplicationGeneratedMessage("info - " + new Random().nextInt(10000),
                            Arrays.asList(LoggingMediums.FILE, LoggingMediums.DB)));
                    logger.debug(new ApplicationGeneratedMessage("debug - " + new Random().nextInt(10000),
                            Arrays.asList(LoggingMediums.FILE, LoggingMediums.DB)));
                    logger.warning(new ApplicationGeneratedMessage("warn - " + new Random().nextInt(10000),
                            Arrays.asList(LoggingMediums.FILE, LoggingMediums.DB)));
                    logger.error(new ApplicationGeneratedMessage("error - " + new Random().nextInt(10000),
                            Arrays.asList(LoggingMediums.FILE, LoggingMediums.DB)));

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
