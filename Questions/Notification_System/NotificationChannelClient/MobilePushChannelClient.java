package Questions.Notification_System.NotificationChannelClient;

public interface MobilePushChannelClient {
    void sendPush(String deviceToken, String message);
}
