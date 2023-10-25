package Questions.Notification_System.Service.PriorityHandler.Impl;

import Questions.Notification_System.Service.Notifier.BaseNotifier;
import Questions.Notification_System.Service.PriorityHandler.PriorityHandler;

public class HighPriorityHandler implements PriorityHandler {

    @Override
    public void handlePriority(BaseNotifier baseNotifier, String message) {
        System.out.println("High priority message with notifier: " + baseNotifier.getClass().getName());
        for(int i = 0; i < 3; i++){
            try{
                baseNotifier.sendMessage(message);
            }catch (Exception ex){
                System.out.println("Exception message: " + ex.getMessage() + " and retryCount: " + (i+1));
                continue;
            }
            break;
        }
    }
}
