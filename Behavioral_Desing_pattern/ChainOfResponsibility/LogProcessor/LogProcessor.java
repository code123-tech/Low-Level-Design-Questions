package Behavioral_Desing_pattern.ChainOfResponsibility.LogProcessor;

import Behavioral_Desing_pattern.ChainOfResponsibility.enums.LoggingLevels;

abstract public class LogProcessor {
    private LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(LoggingLevels logLevel, String message){
        if(this.nextLogProcessor == null) {
            System.out.println("Sorry! No Logger found with requested level.");
            return;
        }
        this.nextLogProcessor.log(logLevel, message);
    }
}
