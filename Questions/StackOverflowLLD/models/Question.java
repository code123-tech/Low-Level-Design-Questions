package Questions.StackOverflowLLD.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import Questions.StackOverflowLLD.Enums.EventType;

public class Question extends Post{

    private final String title;
    private final Set<Tag> tags;
    private final List<Answer> answers = new ArrayList<>();
    private Answer acceptedAnswer;

    public Question(String title, String content, User author, Set<Tag> tags) {
        super(UUID.randomUUID().toString(), content, author);
        this.title = title;
        this.tags = tags;
    }


    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public synchronized void acceptAnswer(Answer answer) {

        if(acceptedAnswer != null) {
            System.out.println("Question " + getId() + " already has an accepted answer");
            return;
        }

        if(this.getAuthor().getId().equals(answer.getAuthor().getId())) {
            System.out.println("Question " + getId() + " author cannot accept their own answer");
            return;
        }

        this.acceptedAnswer = answer;
        answer.setAccepted(true);
        notifyPostObservers(new Event(EventType.ACCEPT_ANSWER, author, answer));

    }

    public String getTitle() { return title; }
    public Set<Tag> getTags() { return tags; }
    public List<Answer> getAnswers() { return answers; }
    
}
