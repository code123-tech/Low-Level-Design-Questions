package Questions.Kafka.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Topic {
    String id;
    String name;
    List<Partition> partitions;
    final int maxPartitions;

    public Topic(String name, int numPartitions){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.partitions = new ArrayList<>();
        this.maxPartitions = numPartitions;
        generatePartitions();
    }
    private void generatePartitions(){
        for(int i=0;i<maxPartitions;i++){
            this.partitions.add(new Partition(this));
        }
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Partition> getPartitions() {
        return partitions;
    }
    public int getMaxPartitions() {
        return maxPartitions;
    }
    @Override
    public String toString(){
        return this.name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return this.id.equals(topic.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
