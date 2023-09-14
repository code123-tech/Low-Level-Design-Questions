package Behavioral_Desing_pattern.ChainOfResponsibility.LogProcessor;

import Behavioral_Desing_pattern.ChainOfResponsibility.enums.LoggingLevels;

public class ErrorLogProcessor extends LogProcessor{
    public ErrorLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(LoggingLevels loggingLevel, String message){
        if(loggingLevel.equals(LoggingLevels.ERROR)){
            System.out.println("ERROR: " + message);
            return;
        }
        super.log(loggingLevel, message);
    }
}
