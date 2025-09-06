package Questions.StackOverflowLLD.patterns.observer;

import Questions.StackOverflowLLD.models.Event;

public interface Observer {
    void handleEvent(Event event);
}
