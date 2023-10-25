package Questions.Notification_System.NotificationChannelClient.Impl;

import Questions.Notification_System.NotificationChannelClient.SMSChannelClient;

public class SMSChannelClientImpl implements SMSChannelClient {
    @Override
    public void sendSMS(String phoneNo, String message) {
        throw new RuntimeException("SMS server down"); // Simulating failure
    }
}
