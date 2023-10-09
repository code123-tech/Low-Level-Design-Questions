package Questions.MessageQueue.Worker;

import Questions.MessageQueue.models.Message;
import Questions.MessageQueue.models.Topic;
import Questions.MessageQueue.models.TopicSubscriber;

import java.util.Objects;

public class SubscriberWorker implements Runnable{
    private Topic topic;
    private TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber){
        Objects.requireNonNull(topic);
        Objects.requireNonNull(topicSubscriber);
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @Override
    public void run() {
        synchronized (topicSubscriber){
            while(true){
                try{
                    int offset = topicSubscriber.getOffset().get();
                    while(offset >= topic.getMessages().size()){
                        topicSubscriber.wait();
                    }
                    Message message = topic.getMessages().get(offset);
                    topicSubscriber.getSubscriber().consume(message);

                    topicSubscriber.getOffset().compareAndSet(offset, offset + 1);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void wakeUpIfNeeded(){
        synchronized (topicSubscriber){
            topicSubscriber.notify();
        }
    }
}
