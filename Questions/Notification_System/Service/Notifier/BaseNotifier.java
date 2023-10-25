package Questions.Notification_System.Service.Notifier;

import Questions.Notification_System.Service.PriorityHandler.PriorityHandler;

abstract public class BaseNotifier {
    protected BaseNotifier nextNotifier;
    protected PriorityHandler priorityHandler;

    public void setPriorityHandler(PriorityHandler priorityHandler) {
        this.priorityHandler = priorityHandler;
    }

    public void sendNotification(String message) {
        // if chain is like c2 -> c1 -> null.
        // c2 checks if it is priority one, then it will be sent through priority.
        // and will go to next notifier. (kind of Linked List).
        if (this.priorityHandler != null) {
            this.priorityHandler.handlePriority(this, message);
        }else {
            sendMessage(message);
        }
        if(this.nextNotifier != null){
            this.nextNotifier.sendNotification(message);
        }
    }

    public abstract void sendMessage(String message);
}
