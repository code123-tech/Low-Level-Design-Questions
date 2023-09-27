package Questions.Kafka.repository.Impl;

import Questions.Kafka.models.Topic;
import Questions.Kafka.repository.TopicRepository;

import java.util.HashMap;
import java.util.Map;

public class TopicRepositoryImpl implements TopicRepository {
    private Map<String, Topic> topics;

    public TopicRepositoryImpl(){
        this.topics = new HashMap<>();
    }

    @Override
    public Topic addTopic(Topic topic) {
        if(topics.containsKey(topic.getName())){
            return null;
        }
        this.topics.put(topic.getName(), topic);
        return topic;
    }
}
