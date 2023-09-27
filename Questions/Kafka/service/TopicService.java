package Questions.Kafka.service;

import Questions.Kafka.models.Message;
import Questions.Kafka.models.MessageMetaData;
import Questions.Kafka.models.Topic;

public interface TopicService {
    Topic createTopic(String name, int numPartitions);
    MessageMetaData publishMessage(Topic topic, Message message);
}
