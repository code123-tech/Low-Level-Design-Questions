package Behavioral_Desing_pattern.Observer.Observable;

import Behavioral_Desing_pattern.Observer.Observer.NotificationAlertObserver;

public interface InventoryObservable {
    void addObserver(NotificationAlertObserver notificationAlertObserver);
    void removeObserver(NotificationAlertObserver notificationAlertObserver);
    void notifySubscribers();
    void setStockCount(int newStockCount);
    int getStockCount();
}
