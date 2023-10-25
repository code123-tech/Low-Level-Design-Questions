package Questions.Notification_System.Service.Notifier;

import Questions.Notification_System.NotificationChannelClient.Impl.SMSChannelClientImpl;
import Questions.Notification_System.NotificationChannelClient.SMSChannelClient;

public class SMSNotifier extends BaseNotifier {
    private final SMSChannelClient smsChannelClient;

    public SMSNotifier(BaseNotifier baseNotifier) {
        this.nextNotifier = baseNotifier;
        this.smsChannelClient = new SMSChannelClientImpl();
    }

    @Override
    public void sendMessage(String message) {
        this.smsChannelClient.sendSMS("", message);
    }
}
