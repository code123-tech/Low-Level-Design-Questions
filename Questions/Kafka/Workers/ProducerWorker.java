package Questions.Kafka.Workers;

import Questions.Kafka.models.Message;
import Questions.Kafka.models.MessageMetaData;
import Questions.Kafka.models.Producer;
import Questions.Kafka.models.Topic;
import Questions.Kafka.service.TopicService;

import java.util.Random;

public class ProducerWorker implements Runnable{
    Producer producer;
    Topic topic;
    TopicService topicService;
    public ProducerWorker(Topic topic, Producer producer, TopicService topicService){
        this.topic = topic;
        this.producer = producer;
        this.topicService = topicService;
    }

    @Override
    public void run() {
        while(true){
            Message message = new Message("random message: " + new Random().nextInt(1000000));
            System.out.println("[Thread - " + Thread.currentThread().getName() + " ], [Producer - " + producer + " ], [producing message - " + message + " ], [Topic - " + topic + " ]");
            MessageMetaData messageMetaData = this.topicService.publishMessage(topic, message);
            System.out.println("Message published to: " + messageMetaData);

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
