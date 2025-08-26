package Adapter;

import Adapter.Impl.ThirdPartyService;
import Adapter.Impl.Adapter;
import Adapter.Interfaces.IAdapter;

public class Client {
    public static void main(String[] args) {
        ThirdPartyService adaptee = new ThirdPartyService();
        IAdapter adapter = new Adapter(adaptee);
        adapter.request();
    }
}
