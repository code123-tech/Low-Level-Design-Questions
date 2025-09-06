package Questions.StackOverflowLLD.models;

import java.util.UUID;

public class Comment extends ContentDefinition{

    public Comment(String content, User author) {
        super(UUID.randomUUID().toString(), content, author);
    }

}
