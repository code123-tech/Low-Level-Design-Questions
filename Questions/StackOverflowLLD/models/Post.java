package Questions.StackOverflowLLD.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import Questions.StackOverflowLLD.Enums.EventType;
import Questions.StackOverflowLLD.Enums.VoteType;
import Questions.StackOverflowLLD.patterns.observer.Observer;

public abstract class Post extends ContentDefinition {

    private final AtomicInteger voteCount = new AtomicInteger(0);
    private final Map<String, VoteType> voters = new HashMap<>();
    private final List<Comment> comments = new ArrayList<>();
    private final List<Observer> postObservers = new ArrayList<>();

    public Post(String id, String content, User author){
        super(id, content, author);
    }

    public void addPostObserver(Observer observer){
        postObservers.add(observer);
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    protected void notifyPostObservers(Event event){

        for(Observer observer: postObservers){
            observer.handleEvent(event);
        }
    }


    public synchronized void vote(User voter, VoteType voteType) {

        String voterId = voter.getId();
        if(voters.get(voterId) == voteType){
            System.out.println("User " + voterId + " has already done similar vote for this post");
            return;
        }

        int scoreChange = 0;
        if(voters.containsKey(voterId)) {
            scoreChange = (voteType == VoteType.UPVOTE) ? 2 : -2;
        } else {
            scoreChange = (voteType == VoteType.UPVOTE) ? 1 : -1;
        }

        voters.put(voterId, voteType);
        voteCount.addAndGet(scoreChange);

        EventType eventType = EventType.UPVOTE_QUESTION;

        if(this instanceof Question) {
            eventType = (voteType == VoteType.UPVOTE) ? EventType.UPVOTE_QUESTION : EventType.DOWNVOTE_QUESTION;
        } else {
            eventType = (voteType == VoteType.UPVOTE) ? EventType.UPVOTE_ANSWER : EventType.DOWNVOTE_ANSWER;
        }

        notifyPostObservers(new Event(eventType, voter, this));
    }

}
