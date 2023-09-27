package Questions.Kafka.Strategy;

import Questions.Kafka.models.Message;
import Questions.Kafka.models.MessageMetaData;
import Questions.Kafka.models.Topic;

public interface MessagePublishStrategy {
    MessageMetaData route(Topic topic, Message message);
}
