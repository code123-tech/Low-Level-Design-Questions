package Questions.Kafka;

import Questions.Kafka.Strategy.Impl.RoundRobin_MessagePublishStrategy;
import Questions.Kafka.Workers.ConsumerWorker;
import Questions.Kafka.Workers.ProducerWorker;
import Questions.Kafka.models.Consumer;
import Questions.Kafka.models.ConsumerGroup;
import Questions.Kafka.models.Producer;
import Questions.Kafka.models.Topic;
import Questions.Kafka.repository.Impl.TopicRepositoryImpl;
import Questions.Kafka.service.ConsumerService;
import Questions.Kafka.service.Impl.ConsumerServiceImpl;
import Questions.Kafka.service.Impl.TopicServiceImpl;
import Questions.Kafka.service.TopicService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        /**
         * Topic, Producer, Consumer
         */
        TopicService topicService = new TopicServiceImpl(new TopicRepositoryImpl(), new RoundRobin_MessagePublishStrategy());
        Topic topic = topicService.createTopic("rider_updates", 4);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Producer producer = new Producer();
        executor.execute(new ProducerWorker(topic, producer,topicService));

        ConsumerGroup consumerGroup = new ConsumerGroup();
        ConsumerService consumerService = new ConsumerServiceImpl();

        Consumer consumer1 = new Consumer(consumerGroup);
        consumerService.subscribe(topic, consumer1);
        executor.execute(new ConsumerWorker(consumer1, consumerService));

        Consumer consumer2 = new Consumer(consumerGroup);
        consumerService.subscribe(topic, consumer2);
        executor.execute(new ConsumerWorker(consumer2, consumerService));

        Consumer consumer3 = new Consumer(consumerGroup);
        consumerService.subscribe(topic, consumer3);
        executor.execute(new ConsumerWorker(consumer3, consumerService));

        Consumer consumer4 = new Consumer(consumerGroup);
        consumerService.subscribe(topic, consumer4);
        executor.execute(new ConsumerWorker(consumer4, consumerService));

        Consumer consumer5 = new Consumer(consumerGroup);  // will sit idle
        consumerService.subscribe(topic, consumer5);
        executor.execute(new ConsumerWorker(consumer5, consumerService));

        executor.shutdown();
    }
}
