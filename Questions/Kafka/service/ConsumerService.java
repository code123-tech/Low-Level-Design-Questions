package Questions.Kafka.service;

import Questions.Kafka.models.Consumer;
import Questions.Kafka.models.Message;
import Questions.Kafka.models.Partition;
import Questions.Kafka.models.Topic;

public interface ConsumerService {
    Partition subscribe(Topic topic, Consumer consumer);
    Message consume(Consumer consumer);
}
