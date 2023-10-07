package Questions.MessageQueue.core.Impl;

import Questions.MessageQueue.core.MessageQueue;
import Questions.MessageQueue.models.Message;
import Questions.MessageQueue.models.Subscribers.Subscriber;
import Questions.MessageQueue.models.Topic;

public class MessageQueueImpl implements MessageQueue {

    @Override
    public Topic createTopic(String topicName) {
        return null;
    }

    @Override
    public void publishToTopic(Topic topic, Message message) {

    }

    @Override
    public void subscribeToTopic(Subscriber subscriber, Topic topic) {

    }

    @Override
    public void resetOffsetForSubscriber(Subscriber subscriber, int resetOffsetValue, Topic topic) {

    }
}
