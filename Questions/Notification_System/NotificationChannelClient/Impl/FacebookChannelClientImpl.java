package Questions.Notification_System.NotificationChannelClient.Impl;

import Questions.Notification_System.NotificationChannelClient.FacebookChannelClient;

public class FacebookChannelClientImpl implements FacebookChannelClient {
    @Override
    public void sendNotification(String userDetailsEncrypted, String message) {
        // Integrate with facebook notification API
        System.out.println("Sent facebook notification");
    }
}
