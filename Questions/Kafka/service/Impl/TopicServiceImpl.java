package Questions.Kafka.service.Impl;

import Questions.Kafka.Strategy.MessagePublishStrategy;
import Questions.Kafka.models.Message;
import Questions.Kafka.models.MessageMetaData;
import Questions.Kafka.models.Topic;
import Questions.Kafka.repository.TopicRepository;
import Questions.Kafka.service.TopicService;

import java.util.Objects;

public class TopicServiceImpl implements TopicService {
    private TopicRepository topicRepository;
    private MessagePublishStrategy messagePublishStrategy;

    public TopicServiceImpl(TopicRepository topicRepository, MessagePublishStrategy messagePublishStrategy){
        this.topicRepository = topicRepository;
        this.messagePublishStrategy = messagePublishStrategy;
    }

    @Override
    public Topic createTopic(String name, int numPartitions) {
        Topic topic = new Topic(name, numPartitions);
        return this.topicRepository.addTopic(topic);
    }

    @Override
    public MessageMetaData publishMessage(Topic topic, Message message) {
        Objects.requireNonNull(topic);
        Objects.requireNonNull(message);
        return this.messagePublishStrategy.route(topic, message);
    }
}
