package Behavioral_Desing_pattern.ChainOfResponsibility.LogProcessor;

import Behavioral_Desing_pattern.ChainOfResponsibility.enums.LoggingLevels;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(LoggingLevels loggingLevel, String message){
        if(loggingLevel.equals(LoggingLevels.INFO)){
            System.out.println("INFO: " + message);
            return;
        }
        super.log(loggingLevel, message);
    }
}
