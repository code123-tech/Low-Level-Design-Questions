package Structural_Desing_pattern.Adapter.Impl;

import Structural_Desing_pattern.Adapter.IAdaptee;
import Structural_Desing_pattern.Adapter.IAdapter;

public class Adapter implements IAdapter {
    IAdaptee adaptee;
    public Adapter(IAdaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("Adapter request is called..");
        this.adaptee.request();
    }
}
