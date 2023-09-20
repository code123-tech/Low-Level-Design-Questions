package Questions.MultiThreadedLogger.logger.Impl;

import Questions.MultiThreadedLogger.logger.InternalLogger;
import Questions.MultiThreadedLogger.models.PrintableMessage;

public class FileInternalLoggerImpl implements InternalLogger {
    private FileInternalLoggerImpl(){}

    private static InternalLogger instance;
    public static InternalLogger getInstance(){
        if(instance == null){
            synchronized (InternalLogger.class){
                if(instance == null){
                    instance = new FileInternalLoggerImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void log(PrintableMessage message) {
        System.out.println(message);
    }
}
