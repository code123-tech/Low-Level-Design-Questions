package Behavioral_Desing_pattern.Observer.Observable;

import Behavioral_Desing_pattern.Observer.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneInventoryObservable implements InventoryObservable{
    public List<NotificationAlertObserver> observers = new ArrayList<>();
    public int stockCount = 0;

    public void addObserver(NotificationAlertObserver notificationAlertObserver){
        observers.add(notificationAlertObserver);
    }
    public void removeObserver(NotificationAlertObserver notificationAlertObserver){
        observers.remove(notificationAlertObserver);
    }
    public void notifySubscribers(){
        for(NotificationAlertObserver observer: observers){
            observer.update();
        }
    }
    public void setStockCount(int newStockCount){
        if(stockCount == 0){
            notifySubscribers();
        }
        stockCount += newStockCount;
    }
    public int getStockCount(){
        return stockCount;
    }
}
