package Questions.Notification_System.Service.Notifier;

import Questions.Notification_System.NotificationChannelClient.FacebookChannelClient;
import Questions.Notification_System.NotificationChannelClient.Impl.FacebookChannelClientImpl;

public class FacebookNotifier extends BaseNotifier {
    private final FacebookChannelClient facebookChannelClient;

    public FacebookNotifier(BaseNotifier baseNotifier) {
        this.nextNotifier = baseNotifier;
        this.facebookChannelClient = new FacebookChannelClientImpl();
    }

    @Override
    public void sendMessage(String message) {
        this.facebookChannelClient.sendNotification("", message);
    }
}
