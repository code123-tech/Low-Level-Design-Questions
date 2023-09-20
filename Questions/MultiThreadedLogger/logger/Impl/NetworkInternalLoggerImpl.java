package Questions.MultiThreadedLogger.logger.Impl;

import Questions.MultiThreadedLogger.logger.InternalLogger;
import Questions.MultiThreadedLogger.models.PrintableMessage;

public class NetworkInternalLoggerImpl implements InternalLogger {
    private NetworkInternalLoggerImpl(){}
    private static InternalLogger instance;
    public static InternalLogger getInstance(){
        if(instance == null){
            synchronized (InternalLogger.class){
                if(instance == null){
                    instance = new NetworkInternalLoggerImpl();
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
