package Questions.Kafka.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Partition {
    String id;
    Topic topic;
    List<Message> messages;
    private Lock lock;

    public Partition(Topic topic){
        this.id = UUID.randomUUID().toString();
        this.topic = topic;
        this.messages = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    public String getId() {
        return id;
    }

    public Topic getTopic() {
        return topic;
    }

    public int addMessage(Message message){
        int offset;
        try{
            lock.tryLock();
            this.messages.add(message);
            offset = this.messages.size()-1;
        }finally {
            lock.unlock();
        }
        return offset;
    }

    public Message getMessageAtOffset(int offset){
        if(offset >= this.messages.size()){
            return null;
        }
        return this.messages.get(offset);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partition partition = (Partition) o;
        return Objects.equals(id, partition.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
