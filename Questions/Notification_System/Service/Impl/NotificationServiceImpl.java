package Questions.Notification_System.Service.Impl;

import Questions.Notification_System.Repository.Impl.UserChannelSubscriptionRepoImpl;
import Questions.Notification_System.Repository.UserChannelSubscriptionRepo;
import Questions.Notification_System.Service.NotificationService;
import Questions.Notification_System.enums.Channel;
import Questions.Notification_System.models.Message;
import Questions.Notification_System.models.User;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {
    private UserChannelSubscriptionRepo userChannelSubscriptionRepo;
    public NotificationServiceImpl(){
        userChannelSubscriptionRepo = new UserChannelSubscriptionRepoImpl();
    }
    @Override
    public void subscribeChannel(User user, List<Channel> channels) {
        this.userChannelSubscriptionRepo.subscribeUser(user, channels);
    }

    @Override
    public void sendMessage(User user, Message message) {
        List<Channel> userSubscribedChannels = this.userChannelSubscriptionRepo.getSubscribedChannelByUser(user);
        if(userSubscribedChannels.isEmpty()){
            System.out.println("User: " + user.getName() + " has not subscribed any channel");
            return;
        }
        // need Notification Channel Client based on channel Type to send message.

    }

    @Override
    public void enableUserSubscribedChannel(User user, Channel channel) {
        userChannelSubscriptionRepo.enableChannel(user, channel);
    }

    @Override
    public void disableUserSubscribedChannel(User user, Channel channel) {
        userChannelSubscriptionRepo.disableChannel(user, channel);
    }
}
