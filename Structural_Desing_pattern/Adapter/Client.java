package Structural_Desing_pattern.Adapter;

import Structural_Desing_pattern.Adapter.Impl.ThirdPartyService;
import Structural_Desing_pattern.Adapter.Impl.Adapter;
import Structural_Desing_pattern.Adapter.Interfaces.IAdapter;

public class Client {
    public static void main(String[] args) {
        ThirdPartyService adaptee = new ThirdPartyService();
        IAdapter adapter = new Adapter(adaptee);
        adapter.request();
    }
}
