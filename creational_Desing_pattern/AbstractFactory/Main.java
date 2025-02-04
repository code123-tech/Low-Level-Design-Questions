package creational_Desing_pattern.AbstractFactory;

import creational_Desing_pattern.AbstractFactory.FactoryAbstraction.OSFactoryAdvisor;
import creational_Desing_pattern.AbstractFactory.FactoryAbstraction.OSFactoryInterface;
import creational_Desing_pattern.AbstractFactory.enums.OSCategory;
import creational_Desing_pattern.AbstractFactory.enums.OSType;

public class Main {

    public static void main(String[] args) {
        
        OSFactoryAdvisor osFactoryAdvisor = new OSFactoryAdvisor();
        OSFactoryInterface osFactoryInterface = osFactoryAdvisor.getOSFactoryInterface(OSCategory.COMPUTER_OPERATION_SYSTEM);

        osFactoryInterface.getOSInstance(OSType.WINDOWS).spec();
    }
}
