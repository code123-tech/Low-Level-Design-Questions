package Structural_Desing_pattern.Adapter.Impl;

import Structural_Desing_pattern.Adapter.IAdaptee;

public class Adaptee implements IAdaptee {
    @Override
    public void request() {
        System.out.println("Adaptee is called...");
    }
}
