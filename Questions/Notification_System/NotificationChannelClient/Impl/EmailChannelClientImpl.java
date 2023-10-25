package Questions.Notification_System.NotificationChannelClient.Impl;

import Questions.Notification_System.NotificationChannelClient.EmailChannelClient;

public class EmailChannelClientImpl implements EmailChannelClient {
    @Override
    public void sendEmail(String address, String cc, String bcc, String content) {
        System.out.println("Sent email message to: " + address);
    }
}
