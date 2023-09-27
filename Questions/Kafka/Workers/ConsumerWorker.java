package Questions.Kafka.Workers;

import Questions.Kafka.models.Consumer;
import Questions.Kafka.models.Message;
import Questions.Kafka.service.ConsumerService;

public class ConsumerWorker implements Runnable{
    ConsumerService consumerService;
    Consumer consumer;

    public ConsumerWorker(Consumer consumer, ConsumerService consumerService){
        this.consumer = consumer;
        this.consumerService = consumerService;
    }

    @Override
    public void run() {
        while (true){
            Message message = consumerService.consume(consumer);
            System.out.println("[Thread-" + Thread.currentThread().getName() + "] consumer "
                    + consumer + " consumed message = " + message);
            try{
                Thread.sleep(1200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
