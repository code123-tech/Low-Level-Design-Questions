package creational_Desing_pattern.AbstractFactory.FactoryAbstraction;

import creational_Desing_pattern.AbstractFactory.OSTypeFactory.OS;
import creational_Desing_pattern.AbstractFactory.enums.OSType;

public interface OSFactoryInterface {

    OS getOSInstance(OSType osType);
}
