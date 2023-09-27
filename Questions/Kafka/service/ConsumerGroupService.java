package Questions.Kafka.service;

import Questions.Kafka.models.Consumer;
import Questions.Kafka.models.Message;
import Questions.Kafka.models.Partition;
import Questions.Kafka.models.Topic;

public interface ConsumerGroupService {
    Partition registerConsumer(Topic topic, Consumer consumer);
    Message getMessage_ForConsumer(Consumer consumer);
}
