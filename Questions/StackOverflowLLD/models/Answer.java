package Questions.StackOverflowLLD.models;

import java.util.UUID;

public class Answer extends Post{

    private boolean isAccepted = false;

    public Answer(String content, User author) {
        super(UUID.randomUUID().toString(), content, author);
    }

    public void setAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

}
