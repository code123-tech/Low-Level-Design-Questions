package Questions.MultiThreadedLogger.logger;

import Questions.MultiThreadedLogger.models.PrintableMessage;

public interface InternalLogger {
    void log(PrintableMessage message);
}
