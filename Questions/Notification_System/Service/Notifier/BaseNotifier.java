package Questions.Notification_System.Service.Notifier;

import Questions.Notification_System.Service.PriorityHandler.PriorityHandler;

abstract public class BaseNotifier {
    protected BaseNotifier nextNotifier;
    protected PriorityHandler priorityHandler;

    public void setPriorityHandler(PriorityHandler priorityHandler) {
        this.priorityHandler = priorityHandler;
    }

    public void sendNotification(String message) {
        if (this.priorityHandler != null) {
            this.priorityHandler.handlePriority(this, message);
            return;
        }
        sendMessage(message);
    }

    public abstract void sendMessage(String message);
}
