package Questions.Notification_System.NotificationChannelClient;

public interface SMSChannelClient {
    void sendSMS(String phoneNo, String message);
}
