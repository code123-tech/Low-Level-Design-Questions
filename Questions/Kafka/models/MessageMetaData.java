package Questions.Kafka.models;

public class MessageMetaData {
    Partition partition;
    int offset;

    public MessageMetaData(Partition partition, int offset){
        this.partition = partition;
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "Partition = " + partition.getId() + " offset = " + offset;
    }
}
