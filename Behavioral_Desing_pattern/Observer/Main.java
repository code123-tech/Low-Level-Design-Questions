package Behavioral_Desing_pattern.Observer;

import Behavioral_Desing_pattern.Observer.Observable.InventoryObservable;
import Behavioral_Desing_pattern.Observer.Observable.IphoneInventoryObservable;
import Behavioral_Desing_pattern.Observer.Observer.EmailAlertObserver;
import Behavioral_Desing_pattern.Observer.Observer.MobileAlertObserver;
import Behavioral_Desing_pattern.Observer.Observer.NotificationAlertObserver;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------Observer Design Pattern.------------------");
        InventoryObservable iphoneInventory = new IphoneInventoryObservable();
        NotificationAlertObserver emailObserver = new EmailAlertObserver("swapdutch@gmail.com", iphoneInventory);
        NotificationAlertObserver mobileObserver = new MobileAlertObserver("+919784190774", iphoneInventory);

        iphoneInventory.addObserver(emailObserver);
        iphoneInventory.addObserver(mobileObserver);

        // add new stock
        iphoneInventory.setStockCount(10);
    }
}
