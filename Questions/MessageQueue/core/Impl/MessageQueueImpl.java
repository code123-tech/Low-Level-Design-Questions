package Questions.MessageQueue.core.Impl;

import Questions.MessageQueue.Utils.TopicObservable;
import Questions.MessageQueue.core.MessageQueue;
import Questions.MessageQueue.models.Message;
import Questions.MessageQueue.models.Subscribers.Subscriber;
import Questions.MessageQueue.models.Topic;
import Questions.MessageQueue.models.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MessageQueueImpl implements MessageQueue {
    private Map<String, TopicObservable> topicProcesses;
    public MessageQueueImpl(){
        this.topicProcesses = new HashMap<>();
    }
    @Override
    public Topic createTopic(String topicName) {
        Objects.requireNonNull(topicName);
        Topic topic = new Topic(topicName);
        this.topicProcesses.put(topic.getId(), new TopicObservable(topic));
        System.out.println("Topic created: " + topic.getName());
        return topic;
    }

    @Override
    public void publishToTopic(Topic topic, Message message) {
        Objects.requireNonNull(topic);
        Objects.requireNonNull(message);
        topic.addMessage(message);
        System.out.println(message.getMessage() + " published to topic: " + topic.getName());
        new Thread(() -> topicProcesses.get(topic.getId()).publish()).start();
    }

    @Override
    public void subscribeToTopic(Subscriber subscriber, Topic topic) {
        Objects.requireNonNull(subscriber);
        Objects.requireNonNull(topic);
        TopicSubscriber topicSubscriber = new TopicSubscriber(subscriber);
        topic.addSubscriber(topicSubscriber);
        System.out.println(subscriber.getSubscriberId() + " subscribed to topic: " + topic.getName());
    }

    @Override
    public void resetOffsetForSubscriber(Subscriber subscriber, Integer resetOffsetValue, Topic topic) {
        Objects.requireNonNull(subscriber);
        Objects.requireNonNull(resetOffsetValue);
        Objects.requireNonNull(topic);

        for(TopicSubscriber topicSubscriber: topic.getTopicSubscribers()){
            if(topicSubscriber.getSubscriber().equals(subscriber)){
                topicSubscriber.getOffset().set(resetOffsetValue);
                System.out.println(topicSubscriber.getSubscriber().getSubscriberId() + " offset reset to: " + resetOffsetValue);
                new Thread(() -> topicProcesses.get(topic.getId()).startSubscribe(topicSubscriber)).start();
                break;
            }
        }
    }
}
