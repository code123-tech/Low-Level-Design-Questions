package Questions.MessageQueue.Utils;

import Questions.MessageQueue.Worker.SubscriberWorker;
import Questions.MessageQueue.models.Topic;
import Questions.MessageQueue.models.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TopicObservable {
    private Topic topic;
    private Map<String, SubscriberWorker> subscriberWorkers;

    public TopicObservable(Topic topic){
        Objects.requireNonNull(topic);
        this.topic = topic;
        this.subscriberWorkers = new HashMap<>();
    }

    public void publish(){
        for(TopicSubscriber topicSubscriber: topic.getTopicSubscribers()){
            startSubscribe(topicSubscriber);
        }
    }
    public void startSubscribe(TopicSubscriber topicSubscriber) {
        Objects.requireNonNull(topicSubscriber);
        String subscriberId = topicSubscriber.getSubscriber().getSubscriberId();
        if(subscriberWorkers.containsKey(subscriberId)){
            subscriberWorkers.get(subscriberId).wakeUpIfNeeded();
            return;
        }

        SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
        subscriberWorkers.put(topicSubscriber.getSubscriber().getSubscriberId(), subscriberWorker);
        new Thread(subscriberWorker).start();
    }

}
