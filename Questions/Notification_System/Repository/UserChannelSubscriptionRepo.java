package Questions.Notification_System.Repository;

import Questions.Notification_System.enums.Channel;
import Questions.Notification_System.models.User;

import java.util.List;

public interface UserChannelSubscriptionRepo {
    void subscribeUser(User user, List<Channel> channels);
    List<Channel> getSubscribedChannelByUser(User user);
    void enableChannel(User user, Channel channel);
    void disableChannel(User user, Channel channel);
}
