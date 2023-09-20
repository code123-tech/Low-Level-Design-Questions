package Questions.MultiThreadedLogger.logger;

import Questions.MultiThreadedLogger.models.ApplicationGeneratedMessage;

public interface ApplicationGeneratedLogger {
    void info(ApplicationGeneratedMessage message) throws InterruptedException;
    void error(ApplicationGeneratedMessage message) throws InterruptedException;
    void debug(ApplicationGeneratedMessage message) throws InterruptedException;
    void warning(ApplicationGeneratedMessage message) throws InterruptedException;
}
