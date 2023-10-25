package Questions.Notification_System.Service.Notifier;

import Questions.Notification_System.NotificationChannelClient.Impl.WhatsappChannelClientImpl;
import Questions.Notification_System.NotificationChannelClient.WhatsappChannelClient;

public class WhatsappNotifier extends BaseNotifier {
    private final WhatsappChannelClient whatsappChannelClient;

    public WhatsappNotifier(BaseNotifier baseNotifier) {
        this.nextNotifier = baseNotifier;
        this.whatsappChannelClient = new WhatsappChannelClientImpl();
    }

    @Override
    public void sendMessage(String message) {
        this.whatsappChannelClient.sendNotification("", message);
    }
}
