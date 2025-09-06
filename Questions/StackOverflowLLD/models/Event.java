package Questions.StackOverflowLLD.models;

import Questions.StackOverflowLLD.Enums.EventType;

public class Event {

    private final EventType eventType;
    private final User actor;
    private final Post targetPost;

    public Event(EventType eventType, User actor, Post targetPost){
        this.eventType = eventType;
        this.actor = actor;
        this.targetPost = targetPost;
    }

    public EventType getEventType(){
        return eventType;
    }

    public User getActor(){
        return actor;
    }

    public Post getTargetPost(){
        return targetPost;
    }

}
