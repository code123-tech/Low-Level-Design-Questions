package creational_Desing_pattern.AbstractFactory.FactoryAbstraction;

import creational_Desing_pattern.AbstractFactory.FactoryAbstraction.Impl.ComputerOSFactory;
import creational_Desing_pattern.AbstractFactory.FactoryAbstraction.Impl.MobileOSFactory;
import creational_Desing_pattern.AbstractFactory.enums.OSCategory;

public class OSFactoryAdvisor {

    public OSFactoryInterface getOSFactoryInterface(OSCategory osCategory) {

        switch (osCategory) {

            case COMPUTER_OPERATION_SYSTEM:
                return new ComputerOSFactory();

            case MOBILE_OPERATION_SYSTEM:
                return new MobileOSFactory();
        }

        throw new IllegalArgumentException("Invalid OS Category");
    }
}
