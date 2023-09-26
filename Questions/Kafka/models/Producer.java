package Questions.Kafka.models;

import java.util.UUID;

public class Producer {
    String id;
    public Producer(){
        id = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return id.equals(producer.id);
    }

    @Override
    public int hashCode(){
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "Producer ID: " + this.id;
    }
}
