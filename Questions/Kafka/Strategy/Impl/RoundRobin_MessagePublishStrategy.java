package Questions.Kafka.Strategy.Impl;

import Questions.Kafka.Strategy.MessagePublishStrategy;
import Questions.Kafka.models.Message;
import Questions.Kafka.models.MessageMetaData;
import Questions.Kafka.models.Partition;
import Questions.Kafka.models.Topic;

import java.util.Random;

public class RoundRobin_MessagePublishStrategy implements MessagePublishStrategy {
    @Override
    public MessageMetaData route(Topic topic, Message message) {
        int maxPartitions = topic.getMaxPartitions();
        int randomNumber = new Random().nextInt(maxPartitions);
        Partition partition = topic.getPartitions().get(randomNumber);
        int offset = partition.addMessage(message);
        return new MessageMetaData(partition, offset);
    }
}
