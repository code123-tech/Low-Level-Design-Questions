package Adapter.Impl;

import Adapter.Interfaces.IAdapter;

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
