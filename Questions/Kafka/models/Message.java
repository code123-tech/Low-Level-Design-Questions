package Questions.Kafka.models;

import java.util.UUID;

public class Message {
    String id;
    String message;

    public Message(String message){
        this.id = UUID.randomUUID().toString();
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return id.equals(message1.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString(){
        return this.message;
    }
}
