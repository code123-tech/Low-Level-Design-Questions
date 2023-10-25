package Questions.Notification_System.NotificationChannelClient;

public interface WebPushChannelClient {
    void sendNotification(String userDetailsEncrypted, String message);
}
