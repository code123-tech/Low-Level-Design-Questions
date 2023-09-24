package Questions.WebScrapper.service;

import Questions.WebScrapper.model.Request;
import Questions.WebScrapper.model.Response;

public interface QueueService {
    void publish(Request request) throws InterruptedException;
    Response consume() throws InterruptedException;
}
