package Structural_Desing_pattern.Adapter.Impl;

import Structural_Desing_pattern.Adapter.Interfaces.IAdapter;

public class Adapter implements IAdapter {
    ThirdPartyService adaptee;
    public Adapter(ThirdPartyService adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("Adapter request is called..");
        this.adaptee.request();
    }
}
