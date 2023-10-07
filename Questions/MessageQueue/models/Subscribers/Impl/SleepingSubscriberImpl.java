package Questions.MessageQueue.models.Subscribers.Impl;

import Questions.MessageQueue.models.Message;
import Questions.MessageQueue.models.Subscribers.Subscriber;

import java.util.UUID;

public class SleepingSubscriberImpl implements Subscriber {
    private String subscriberId;
    private int sleepTime;

    public SleepingSubscriberImpl(int sleepTime){
        this.subscriberId = UUID.randomUUID().toString();
        this.sleepTime = sleepTime;
    }

    @Override
    public String getSubscriberId() {
        return subscriberId;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("[Subscriber: " + subscriberId + " ], consuming [Message: " + message.getMessage());
        Thread.sleep(sleepTime);
        System.out.println("[Subscriber: " + subscriberId + " ], done consuming [Message: " + message.getMessage());
    }
}
