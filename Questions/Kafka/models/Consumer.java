package Questions.Kafka.models;

import java.util.UUID;

public class Consumer {
    String id;
    ConsumerGroup consumerGroup;
    public Consumer(ConsumerGroup consumerGroup){
        this.id = UUID.randomUUID().toString();
        this.consumerGroup = consumerGroup;
        this.consumerGroup.addConsumer(this);
    }

    public String getId() {
        return id;
    }
    public ConsumerGroup getConsumerGroup() {
        if(consumerGroup == null){
            return ConsumerGroup.getDefaultInstance();
        }
        return consumerGroup;
    }
    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumer consumer = (Consumer) o;
        return this.id.equals(consumer.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
