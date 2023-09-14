package Behavioral_Desing_pattern.ChainOfResponsibility.LogProcessor;

import Behavioral_Desing_pattern.ChainOfResponsibility.enums.LoggingLevels;

public class DebugLogProcessor extends LogProcessor{
    public DebugLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(LoggingLevels loggingLevel, String message){
        if(loggingLevel.equals(LoggingLevels.DEBUG)){
            System.out.println("DEBUG: " + message);
            return;
        }
        super.log(loggingLevel, message);
    }
}
