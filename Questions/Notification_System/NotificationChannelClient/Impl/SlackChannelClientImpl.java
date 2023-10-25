package Questions.Notification_System.NotificationChannelClient.Impl;

import Questions.Notification_System.NotificationChannelClient.SlackChannelClient;

public class SlackChannelClientImpl implements SlackChannelClient {
    @Override
    public void sendNotification(String userDetailsEncrypted, String message) {
        System.out.println("Sent slack notification");
    }
}
