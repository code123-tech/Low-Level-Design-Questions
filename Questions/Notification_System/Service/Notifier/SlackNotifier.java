package Questions.Notification_System.Service.Notifier;

import Questions.Notification_System.NotificationChannelClient.Impl.SlackChannelClientImpl;
import Questions.Notification_System.NotificationChannelClient.SlackChannelClient;

public class SlackNotifier extends BaseNotifier {
    private final SlackChannelClient slackChannelClient;

    public SlackNotifier(BaseNotifier baseNotifier) {
        this.nextNotifier = baseNotifier;
        this.slackChannelClient = new SlackChannelClientImpl();
    }

    @Override
    public void sendMessage(String message) {
        this.slackChannelClient.sendNotification("", message);
    }
}
