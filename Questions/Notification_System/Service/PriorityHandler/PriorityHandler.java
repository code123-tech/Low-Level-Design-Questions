package Questions.Notification_System.Service.PriorityHandler;

import Questions.Notification_System.Service.Notifier.BaseNotifier;

public interface PriorityHandler {
    void handlePriority(BaseNotifier baseNotifier, String message);
}
