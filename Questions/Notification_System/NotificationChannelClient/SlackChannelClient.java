package Questions.Notification_System.NotificationChannelClient;

public interface SlackChannelClient {
    void sendNotification(String userDetailsEncrypted, String message);
}
