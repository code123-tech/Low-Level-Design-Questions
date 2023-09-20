package Questions.MultiThreadedLogger.logger.Impl;

import Questions.MultiThreadedLogger.Services.QueueService;
import Questions.MultiThreadedLogger.enums.LoggingLevels;
import Questions.MultiThreadedLogger.enums.LoggingMediums;
import Questions.MultiThreadedLogger.logger.ApplicationGeneratedLogger;
import Questions.MultiThreadedLogger.models.ApplicationGeneratedMessage;
import Questions.MultiThreadedLogger.models.PrintableMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Logger to publish message by application.
 */
public class ApplicationGeneratedLoggerImpl implements ApplicationGeneratedLogger {
    private QueueService queueService;

    public ApplicationGeneratedLoggerImpl(QueueService queueService){
        this.queueService = queueService;
    }

    @Override
    public void info(ApplicationGeneratedMessage message) throws InterruptedException {
        this.queueService.publish(getWritableMessage(message, LoggingLevels.INFO));
    }

    @Override
    public void error(ApplicationGeneratedMessage message) throws InterruptedException {
        this.queueService.publish(getWritableMessage(message, LoggingLevels.ERROR));
    }

    @Override
    public void debug(ApplicationGeneratedMessage message) throws InterruptedException {
        this.queueService.publish(getWritableMessage(message, LoggingLevels.DEBUG));
    }

    @Override
    public void warning(ApplicationGeneratedMessage message) throws InterruptedException {
        this.queueService.publish(getWritableMessage(message, LoggingLevels.WARNING));
    }
    private List<PrintableMessage> getWritableMessage(ApplicationGeneratedMessage message, LoggingLevels level) {
        List<PrintableMessage> printableMessages = new ArrayList<>();
        for(LoggingMediums medium: message.getMediums()){
            printableMessages.add(new PrintableMessage(message, level, medium));
        }
        return printableMessages;
    }
}
