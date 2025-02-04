package creational_Desing_pattern.AbstractFactory.FactoryAbstraction.Impl;

import creational_Desing_pattern.AbstractFactory.FactoryAbstraction.OSFactoryInterface;
import creational_Desing_pattern.AbstractFactory.OSTypeFactory.Android;
import creational_Desing_pattern.AbstractFactory.OSTypeFactory.IOS;
import creational_Desing_pattern.AbstractFactory.OSTypeFactory.OS;
import creational_Desing_pattern.AbstractFactory.enums.OSType;

public class MobileOSFactory implements OSFactoryInterface {

    @Override
    public OS getOSInstance(OSType osType) {
       
        switch (osType){
            
            case ANDROID:
                return new Android();

            case IOS:
                return new IOS();
        } 
        
        throw new IllegalArgumentException("Invalid Mobile OS Type");
    }

}
