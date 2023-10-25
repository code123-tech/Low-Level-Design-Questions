package Questions.Notification_System.Repository.Impl;

import Questions.Notification_System.Repository.UserChannelSubscriptionRepo;
import Questions.Notification_System.enums.Channel;
import Questions.Notification_System.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserChannelSubscriptionRepoImpl implements UserChannelSubscriptionRepo {
    private Map<User, Map<Channel, Boolean>> userSubscribedChannels;
    public UserChannelSubscriptionRepoImpl(){
        this.userSubscribedChannels = new HashMap<>();
    }
    @Override
    public void subscribeUser(User user, List<Channel> channels) {
        this.userSubscribedChannels.putIfAbsent(user, new HashMap<>());
        for(Channel channel: channels){
            this.userSubscribedChannels.get(user).putIfAbsent(channel, Boolean.TRUE);
        }
        System.out.println("User: " + user.getName() + " has subscribed to given channels.");
    }

    @Override
    public List<Channel> getSubscribedChannelByUser(User user) {
        Map<Channel, Boolean> subscribedChannels = this.userSubscribedChannels.getOrDefault(user, new HashMap<>());
        return subscribedChannels.keySet().stream().filter(channel -> subscribedChannels.get(channel)).collect(Collectors.toList());
    }

    @Override
    public void enableChannel(User user, Channel channel) {
        Map<Channel, Boolean> subscribedChannel = this.userSubscribedChannels.getOrDefault(user, null);
        if(subscribedChannel == null || subscribedChannel.containsKey(channel) == false){
            System.out.println("User: " + user.getName() + " is not subscribed to channel: " + channel.name());
            return;
        }
        subscribedChannel.put(channel, Boolean.TRUE);
        this.userSubscribedChannels.put(user, subscribedChannel);
        System.out.println("User: " + user.getName() + " has enabled notification through channel: " + channel.name());
    }

    @Override
    public void disableChannel(User user, Channel channel) {
        Map<Channel, Boolean> subscribedChannel = this.userSubscribedChannels.getOrDefault(user, null);
        if(subscribedChannel == null || subscribedChannel.containsKey(channel) == false){
            System.out.println("User: " + user.getName() + " is not subscribed to channel: " + channel.name());
            return;
        }
        subscribedChannel.put(channel, Boolean.FALSE);
        this.userSubscribedChannels.put(user, subscribedChannel);
        System.out.println("User: " + user.getName() + " has disabled notification through channel: " + channel.name());
    }
}
