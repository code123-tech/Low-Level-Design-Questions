package Questions.Kafka.models;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerGroup {
    private static ConsumerGroup defaultInstance;
    String id;
    private final Set<Consumer> consumers;
    private final Map<Partition, Integer> currentOffset;
    private final Map<Partition, Integer> commitedOffset;
    private final Map<Consumer, Partition> partitionMappedToConsumer;
    private final Lock lock;

    public ConsumerGroup() {
        this.id = UUID.randomUUID().toString();
        this.consumers = new HashSet<>();
        this.currentOffset = new HashMap<>();
        this.commitedOffset = new HashMap<>();
        this.partitionMappedToConsumer = new HashMap<>();
        this.lock = new ReentrantLock();
    }
    public static ConsumerGroup getDefaultInstance() {
        if (defaultInstance == null) {
            defaultInstance = new ConsumerGroup();
            defaultInstance.id = "default-id";
        }
        return defaultInstance;
    }

    public void addConsumer(Consumer consumer){
        Objects.requireNonNull(consumer);
        this.consumers.add(consumer);
    }
    public void assignPartition(Partition partition, Consumer consumer){
        Objects.requireNonNull(partition);
        Objects.requireNonNull(consumer);
        this.currentOffset.put(partition,-1);
        this.partitionMappedToConsumer.put(consumer, partition);
    }

    public Integer totalConsumers(){
        return consumers.size();
    }
    public Message fetchMessage_ForConsumer(Consumer consumer){
        Message message = null;
        Partition partition = this.partitionMappedToConsumer.get(consumer);
        if(partition == null) return message;

        try{
            lock.lock();
            int nextOffset = this.currentOffset.get(partition) + 1;
            message = partition.getMessageAtOffset(nextOffset);
            if(message == null) return message;

            this.currentOffset.put(partition, nextOffset);
        }finally {
            lock.unlock();
        }
        return message;
    }
    public Boolean isPartitionAssigned(Partition partition){
        Set<Partition> allocatedPartitions = new HashSet<>(this.partitionMappedToConsumer.values());
        return allocatedPartitions.contains(partition);
    }
    public String getId(){
        return this.id;
    }

    public Set<Consumer> getConsumers(){
        return this.consumers;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumerGroup that = (ConsumerGroup) o;
        return this.id.equals(that.id);
    }
}
