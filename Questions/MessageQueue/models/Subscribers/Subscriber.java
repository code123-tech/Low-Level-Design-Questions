package Questions.MessageQueue.models.Subscribers;

import Questions.MessageQueue.models.Message;

public interface Subscriber {
    String getSubscriberId();
    void consume(Message message) throws InterruptedException;
}
