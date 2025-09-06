package Questions.StackOverflowLLD.models;

import java.time.LocalDateTime;

public abstract class ContentDefinition {

    protected String id;
    protected String content;
    protected User author;
    protected LocalDateTime creationTime;

    public ContentDefinition(String id, String content, User author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.creationTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }
    
    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

}
