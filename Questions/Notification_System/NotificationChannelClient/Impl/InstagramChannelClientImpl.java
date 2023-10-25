package Questions.Notification_System.NotificationChannelClient.Impl;

import Questions.Notification_System.NotificationChannelClient.InstagramChannelClient;

public class InstagramChannelClientImpl implements InstagramChannelClient {
    @Override
    public void sendNotification(String userDetailsEncrypted, String message) {
        System.out.println("Sent Instagram notification");
    }
}
