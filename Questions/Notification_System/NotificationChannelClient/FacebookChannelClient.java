package Questions.Notification_System.NotificationChannelClient;

public interface FacebookChannelClient {
    void sendNotification(String userDetailsEncrypted, String message);
}
