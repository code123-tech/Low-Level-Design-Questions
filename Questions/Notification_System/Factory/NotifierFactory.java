package Questions.Notification_System.Factory;

import Questions.Notification_System.Service.Notifier.*;
import Questions.Notification_System.enums.Channel;

public class NotifierFactory {
    public static BaseNotifier getNotifierBasedOnChannel(Channel channel, BaseNotifier notifier){
        switch (channel){
            case EMAIL:
                return new EmailNotifier(notifier);
            case FACEBOOK:
                return new FacebookNotifier(notifier);
            case INSTAGRAM:
                return new InstagramNotifier(notifier);
            case MOBILE_PUSH:
                return new MobilePushNotifier(notifier);
            case SLACK:
                return new SlackNotifier(notifier);
            case SMS:
                return new SMSNotifier(notifier);
            case WEB_PUSH:
                return new WebPushNotifier(notifier);
            case WHATSAPP:
                return new WhatsappNotifier(notifier);
            default:
                return null;
        }
    }
}
