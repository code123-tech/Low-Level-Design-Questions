package Questions.MessageQueue.core;

import Questions.MessageQueue.models.Message;
import Questions.MessageQueue.models.Subscribers.Subscriber;
import Questions.MessageQueue.models.Topic;

public interface MessageQueue {
    Topic createTopic(String topicName);
    void publishToTopic(Topic topic, Message message);
    void subscribeToTopic(Subscriber subscriber, Topic topic);
    void resetOffsetForSubscriber(Subscriber subscriber, Integer resetOffsetValue, Topic topic);
}
