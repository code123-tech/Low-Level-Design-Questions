package Questions.MessageQueue.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Topic {
    private String id;
    private String name;
    private List<TopicSubscriber> topicSubscribers;
    private List<Message> messages;
    public Topic(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.topicSubscribers = new ArrayList<>();
        this.messages = new ArrayList<>();
    }
    public void addSubscriber(TopicSubscriber topicSubscriber){
        Objects.requireNonNull(topicSubscriber);
        this.topicSubscribers.add(topicSubscriber);
    }
    public void addMessage(Message message){
        Objects.requireNonNull(message);
        this.messages.add(message);
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TopicSubscriber> getTopicSubscribers() {
        return topicSubscribers;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
