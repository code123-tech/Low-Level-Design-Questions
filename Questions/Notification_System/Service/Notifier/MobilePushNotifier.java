package Questions.Notification_System.Service.Notifier;

import Questions.Notification_System.NotificationChannelClient.Impl.MobilePushChannelClientImpl;
import Questions.Notification_System.NotificationChannelClient.MobilePushChannelClient;

public class MobilePushNotifier extends BaseNotifier {
    private final MobilePushChannelClient mobilePushChannelClient;

    public MobilePushNotifier(BaseNotifier baseNotifier) {
        this.nextNotifier = baseNotifier;
        this.mobilePushChannelClient = new MobilePushChannelClientImpl();
    }

    @Override
    public void sendMessage(String message) {
        this.mobilePushChannelClient.sendPush("", message);
    }
}
