package Questions.Notification_System.NotificationChannelClient;

public interface EmailChannelClient {
    void sendEmail(String address, String cc, String bcc, String content);
}
