package Questions.MultiThreadedLogger.models;

import Questions.MultiThreadedLogger.enums.LoggingLevels;
import Questions.MultiThreadedLogger.enums.LoggingMediums;

public class PrintableMessage {
    private ApplicationGeneratedMessage applicationGeneratedMessage;
    private LoggingLevels level;
    private LoggingMediums medium;

    public PrintableMessage(ApplicationGeneratedMessage applicationGeneratedMessage, LoggingLevels level, LoggingMediums medium){
        this.applicationGeneratedMessage = applicationGeneratedMessage;
        this.level = level;
        this.medium = medium;
    }

    public ApplicationGeneratedMessage getApplicationGeneratedMessage() {
        return applicationGeneratedMessage;
    }

    public LoggingLevels getLevel() {
        return level;
    }

    public LoggingMediums getMedium() {
        return medium;
    }

    @Override
    public String toString() {
        return "Log Level = " + level
                + ", medium = " + medium
                + ", Thread = " + applicationGeneratedMessage.getCurrentThread().getName()
                + ", timestamp = " + applicationGeneratedMessage.getTime().toString()
                + ", message = " + applicationGeneratedMessage.getMessage();
    }
}
