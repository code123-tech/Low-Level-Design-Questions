package Questions.Kafka.service.Impl;

import Questions.Kafka.models.*;
import Questions.Kafka.service.ConsumerGroupService;

public class ConsumerGroupServiceImpl implements ConsumerGroupService {

    @Override
    public Partition registerConsumer(Topic topic, Consumer consumer) {
        ConsumerGroup consumerGroup = consumer.getConsumerGroup();
        if(consumerGroup.totalConsumers() > topic.getMaxPartitions()){
            System.out.println("Consumer: " + consumer.getId() + " will be idle for the topic: " + topic.getName());
            return null;
        }
        for(Partition partition: topic.getPartitions()){
            if(consumerGroup.isPartitionAssigned(partition)) continue;

            consumerGroup.assignPartition(partition, consumer);
            return partition;
        }
        System.out.println("Consumer: " + consumer.getId() + " has allocated no partition, for the topic: " + topic.getName());
        return null;
    }

    @Override
    public Message getMessage_ForConsumer(Consumer consumer) {
        ConsumerGroup consumerGroup = consumer.getConsumerGroup();
        return consumerGroup.fetchMessage_ForConsumer(consumer);
    }
}
