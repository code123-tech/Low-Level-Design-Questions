package Questions.StackOverflowLLD.patterns.observer;

import Questions.StackOverflowLLD.models.Event;
import Questions.StackOverflowLLD.models.User;

public class ReputationObserver implements Observer{

    private static final int QUESTION_UPVOTE_REPUTATION = 5;
    private static final int ANSWER_UPVOTE_REPUTATION = 10;
    private static final int ANSWER_ACCEPTED_REPUTATION = 15;
    private static final int POST_DOWNVOTE_REPUTATION = -2;
    private static final int DOWNVOTE_REPUTATION_FOR_VOTER = -1;

    @Override
    public void handleEvent(Event event){
        
        User author = event.getTargetPost().getAuthor();

        switch (event.getEventType()) {

            case UPVOTE_QUESTION: 
                author.updateReputation(QUESTION_UPVOTE_REPUTATION);
                return;
            
            case DOWNVOTE_QUESTION:
            case DOWNVOTE_ANSWER:
                author.updateReputation(POST_DOWNVOTE_REPUTATION);
                event.getActor().updateReputation(DOWNVOTE_REPUTATION_FOR_VOTER);
                return;
            
            case UPVOTE_ANSWER:
                author.updateReputation(ANSWER_UPVOTE_REPUTATION);
                return;
            
            case ACCEPT_ANSWER:
                author.updateReputation(ANSWER_ACCEPTED_REPUTATION);
                return;

        }
    
        throw new IllegalArgumentException("Invalid event type: " + event.getEventType());
    }
    
}
