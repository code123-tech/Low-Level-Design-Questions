package Questions.Notification_System.Service;

import Questions.Notification_System.enums.Channel;
import Questions.Notification_System.models.Message;
import Questions.Notification_System.models.User;

import java.util.List;

public interface NotificationService {
    void subscribeChannel(User user, List<Channel> channels);
    void sendMessage(User user, Message message);
    void enableUserSubscribedChannel(User user, Channel channel);
    void disableUserSubscribedChannel(User user, Channel channel);
}
