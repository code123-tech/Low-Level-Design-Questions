package Questions.Notification_System.Service.Notifier;

import Questions.Notification_System.NotificationChannelClient.EmailChannelClient;
import Questions.Notification_System.NotificationChannelClient.Impl.EmailChannelClientImpl;

public class EmailNotifier extends BaseNotifier {
    private final EmailChannelClient emailChannelClient;

    public EmailNotifier(BaseNotifier baseNotifier) {
        this.nextNotifier = baseNotifier;
        this.emailChannelClient = new EmailChannelClientImpl();
    }

    @Override
    public void sendMessage(String message) {
        this.emailChannelClient.sendEmail("", "", "", message);
    }
}
