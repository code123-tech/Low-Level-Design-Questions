package Questions.WebScrapper.Worker;


import Questions.WebScrapper.Utils.Data;
import Questions.WebScrapper.model.Response;
import Questions.WebScrapper.service.QueueService;

public class Consumer implements Runnable{
    private QueueService queueService;
    public Consumer(QueueService queueService){
        this.queueService = queueService;
    }

    @Override
    public void run() {
        for(int i=0;i < Data.requests.length;i++){
            try{
                Response response = this.queueService.consume();
                System.out.println(response);
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
