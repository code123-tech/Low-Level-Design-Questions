package Behavioral_Desing_pattern.ChainOfResponsibility;

import Behavioral_Desing_pattern.ChainOfResponsibility.Chain.Chain;
import Behavioral_Desing_pattern.ChainOfResponsibility.enums.LoggingLevels;

public class Main {
    public static void main(String[] args) {
        Chain chain = new Chain();

        chain.log(LoggingLevels.INFO, "Information is there.");
        chain.log(LoggingLevels.ERROR, "Error is there.");
        chain.log(LoggingLevels.DEBUG, "Debug is there.");
        chain.log(LoggingLevels.MESSAGE, "Message is there.");
    }
}
