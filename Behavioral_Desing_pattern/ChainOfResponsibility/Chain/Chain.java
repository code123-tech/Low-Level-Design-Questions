package Behavioral_Desing_pattern.ChainOfResponsibility.Chain;

import Behavioral_Desing_pattern.ChainOfResponsibility.LogProcessor.DebugLogProcessor;
import Behavioral_Desing_pattern.ChainOfResponsibility.LogProcessor.ErrorLogProcessor;
import Behavioral_Desing_pattern.ChainOfResponsibility.LogProcessor.InfoLogProcessor;
import Behavioral_Desing_pattern.ChainOfResponsibility.LogProcessor.LogProcessor;
import Behavioral_Desing_pattern.ChainOfResponsibility.enums.LoggingLevels;

public class Chain {
    LogProcessor logProcessor;

    public Chain(){
        buildChain();
    }
    private void buildChain(){
        logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
    }

    public void log(LoggingLevels loggingLevel, String message){
        this.logProcessor.log(loggingLevel, message);
    }
}
