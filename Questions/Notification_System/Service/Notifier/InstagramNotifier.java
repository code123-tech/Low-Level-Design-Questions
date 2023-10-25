package Questions.Notification_System.Service.Notifier;

import Questions.Notification_System.NotificationChannelClient.Impl.InstagramChannelClientImpl;
import Questions.Notification_System.NotificationChannelClient.InstagramChannelClient;

public class InstagramNotifier extends BaseNotifier {
    private final InstagramChannelClient instagramChannelClient;

    public InstagramNotifier(BaseNotifier baseNotifier) {
        this.nextNotifier = baseNotifier;
        this.instagramChannelClient = new InstagramChannelClientImpl();
    }

    @Override
    public void sendMessage(String message) {
        this.instagramChannelClient.sendNotification("", message);
    }
}
