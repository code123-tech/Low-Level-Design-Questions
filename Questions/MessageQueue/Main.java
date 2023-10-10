package Questions.MessageQueue;

import Questions.MessageQueue.core.Impl.MessageQueueImpl;
import Questions.MessageQueue.core.MessageQueue;
import Questions.MessageQueue.models.Message;
import Questions.MessageQueue.models.Subscribers.Impl.SleepingSubscriberImpl;
import Questions.MessageQueue.models.Subscribers.Subscriber;
import Questions.MessageQueue.models.Topic;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        MessageQueue messageQueue = new MessageQueueImpl();
        Topic topic1 = messageQueue.createTopic("topic1");
        Topic topic2 = messageQueue.createTopic("topic2");

        Subscriber sleepingSubscriber1 = new SleepingSubscriberImpl(10000);
        Subscriber sleepingSubscriber2 = new SleepingSubscriberImpl(10000);
        messageQueue.subscribeToTopic(sleepingSubscriber1, topic1);
        messageQueue.subscribeToTopic(sleepingSubscriber2, topic1);

        Subscriber sleepingSubscriber3 = new SleepingSubscriberImpl(5000);
        messageQueue.subscribeToTopic(sleepingSubscriber3, topic2);

        messageQueue.publishToTopic(topic1, new Message("m1"));
        messageQueue.publishToTopic(topic1, new Message("m2"));

        messageQueue.publishToTopic(topic2, new Message("m3"));

        Thread.sleep(15000);
        messageQueue.publishToTopic(topic2, new Message("m4"));
        messageQueue.publishToTopic(topic1, new Message("m5"));

        messageQueue.resetOffsetForSubscriber(sleepingSubscriber1, 0, topic1);
    }
}
