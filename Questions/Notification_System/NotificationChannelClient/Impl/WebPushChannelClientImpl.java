package Questions.Notification_System.NotificationChannelClient.Impl;

import Questions.Notification_System.NotificationChannelClient.WebPushChannelClient;

public class WebPushChannelClientImpl implements WebPushChannelClient {
    @Override
    public void sendNotification(String userDetailsEncrypted, String message) {
        System.out.println("Web push notification sent");
    }
}
