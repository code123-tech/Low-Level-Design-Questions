package Structural_Desing_pattern.Adapter;

import Structural_Desing_pattern.Adapter.Impl.Adaptee;
import Structural_Desing_pattern.Adapter.Impl.Adapter;

public class Client {
    public static void main(String[] args) {
        IAdaptee adaptee = new Adaptee();
        IAdapter adapter = new Adapter(adaptee);
        adapter.request();
    }
}
