package Questions.Kafka.repository;

import Questions.Kafka.models.Topic;

public interface TopicRepository {
    Topic addTopic(Topic topic);
}
