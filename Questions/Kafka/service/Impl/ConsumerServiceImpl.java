package Questions.Kafka.service.Impl;

import Questions.Kafka.models.Consumer;
import Questions.Kafka.models.Message;
import Questions.Kafka.models.Partition;
import Questions.Kafka.models.Topic;
import Questions.Kafka.service.ConsumerGroupService;
import Questions.Kafka.service.ConsumerService;

import java.util.Objects;

public class ConsumerServiceImpl implements ConsumerService {
    private ConsumerGroupService consumerGroupService;
    public ConsumerServiceImpl(){
        this.consumerGroupService = new ConsumerGroupServiceImpl();
    }

    @Override
    public Partition subscribe(Topic topic, Consumer consumer) {
        Objects.requireNonNull(topic);
        Objects.requireNonNull(consumer);
        return this.consumerGroupService.registerConsumer(topic, consumer);
    }

    @Override
    public Message consume(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return this.consumerGroupService.getMessage_ForConsumer(consumer);
    }
}
