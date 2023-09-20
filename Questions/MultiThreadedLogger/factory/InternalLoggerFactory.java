package Questions.MultiThreadedLogger.factory;

import Questions.MultiThreadedLogger.enums.LoggingMediums;
import Questions.MultiThreadedLogger.logger.Impl.DBInternalLoggerImpl;
import Questions.MultiThreadedLogger.logger.Impl.FileInternalLoggerImpl;
import Questions.MultiThreadedLogger.logger.Impl.NetworkInternalLoggerImpl;
import Questions.MultiThreadedLogger.logger.InternalLogger;

public class InternalLoggerFactory {
    public static InternalLogger getLoggerInstance(LoggingMediums medium){
        switch (medium){
            case FILE:
                return FileInternalLoggerImpl.getInstance();
            case DB:
                return DBInternalLoggerImpl.getInstance();
            case NETWORK:
                return NetworkInternalLoggerImpl.getInstance();
            default:
                return null;
        }
    }
}
