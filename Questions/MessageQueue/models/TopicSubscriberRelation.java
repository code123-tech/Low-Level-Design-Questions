package Questions.MessageQueue.models;

import Questions.MessageQueue.models.Subscribers.Subscriber;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriberRelation {
    private AtomicInteger offset;
    private Subscriber subscriber;

    public TopicSubscriberRelation(Subscriber subscriber){
        Objects.requireNonNull(subscriber);
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }
}
