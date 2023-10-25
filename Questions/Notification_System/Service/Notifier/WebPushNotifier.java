package Questions.Notification_System.Service.Notifier;

import Questions.Notification_System.NotificationChannelClient.Impl.WebPushChannelClientImpl;
import Questions.Notification_System.NotificationChannelClient.WebPushChannelClient;

public class WebPushNotifier extends BaseNotifier {
    private final WebPushChannelClient webPushChannelClient;

    public WebPushNotifier(BaseNotifier baseNotifier) {
        this.nextNotifier = baseNotifier;
        this.webPushChannelClient = new WebPushChannelClientImpl();
    }

    @Override
    public void sendMessage(String message) {
        this.webPushChannelClient.sendNotification("", message);
    }
}
