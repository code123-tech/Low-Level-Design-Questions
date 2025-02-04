package creational_Desing_pattern.AbstractFactory.FactoryAbstraction.Impl;

import creational_Desing_pattern.AbstractFactory.FactoryAbstraction.OSFactoryInterface;
import creational_Desing_pattern.AbstractFactory.OSTypeFactory.Linux;
import creational_Desing_pattern.AbstractFactory.OSTypeFactory.MacOS;
import creational_Desing_pattern.AbstractFactory.OSTypeFactory.OS;
import creational_Desing_pattern.AbstractFactory.OSTypeFactory.Windows;
import creational_Desing_pattern.AbstractFactory.enums.OSType;

public class ComputerOSFactory implements OSFactoryInterface {

    @Override
    public OS getOSInstance(OSType osType) {
       
        switch (osType){
            
            case WINDOWS:
                return new Windows();

            case LINUX:
                return new Linux();

            case MACOS:
                return new MacOS();
        } 
        
        throw new IllegalArgumentException("Invalid Computer OS Type");
    }

}
