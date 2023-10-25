package Questions.Notification_System.NotificationChannelClient.Impl;

import Questions.Notification_System.NotificationChannelClient.MobilePushChannelClient;

public class MobilePushChannelClientImpl implements MobilePushChannelClient {
    @Override
    public void sendPush(String deviceToken, String message) {
        System.out.println("Mobile push notification sent");
    }
}
