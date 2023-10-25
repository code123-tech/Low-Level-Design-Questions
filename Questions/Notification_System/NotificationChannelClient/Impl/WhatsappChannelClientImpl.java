package Questions.Notification_System.NotificationChannelClient.Impl;

import Questions.Notification_System.NotificationChannelClient.WhatsappChannelClient;

public class WhatsappChannelClientImpl implements WhatsappChannelClient {
    @Override
    public void sendNotification(String phoneNo, String message) {
        System.out.println("Sent Whatsapp notification");
    }
}
