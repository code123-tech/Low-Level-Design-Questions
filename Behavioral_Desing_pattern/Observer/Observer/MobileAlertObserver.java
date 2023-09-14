package Behavioral_Desing_pattern.Observer.Observer;

import Behavioral_Desing_pattern.Observer.Observable.InventoryObservable;

public class MobileAlertObserver implements NotificationAlertObserver{
    String mobileNumber;
    InventoryObservable inventoryObservable;

    public MobileAlertObserver(String mobileNumber, InventoryObservable inventoryObservable){
        this.mobileNumber = mobileNumber;
        this.inventoryObservable = inventoryObservable;
    }
    @Override
    public void update(){
        sendMessage(mobileNumber, "product is in stock..");
    }

    private void sendMessage(String mobileNumber, String msg){
        System.out.println("message: " + msg + " is sent to mobile number: " + mobileNumber);
    }
}
