package Questions.StackOverflowLLD.models;

import java.util.UUID;

public class Tag {

    private String id;
    private String name;
    
    public Tag(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

}
