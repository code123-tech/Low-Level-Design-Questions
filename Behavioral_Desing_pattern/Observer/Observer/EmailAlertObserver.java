package Behavioral_Desing_pattern.Observer.Observer;

import Behavioral_Desing_pattern.Observer.Observable.InventoryObservable;

public class EmailAlertObserver implements NotificationAlertObserver{
    String emailId;
    InventoryObservable inventoryObservable;

    public EmailAlertObserver(String emailId, InventoryObservable inventoryObservable){
        this.emailId = emailId;
        this.inventoryObservable = inventoryObservable;
    }
    @Override
    public void update(){
        sendMessage(emailId, "product is in stock..");
    }

    private void sendMessage(String emailId, String msg){
        System.out.println("message: " + msg + " is sent to email Id: " + emailId);
    }
}
