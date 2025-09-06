package Questions.StackOverflowLLD.models;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private String id;
    private String name;
    private String email;
    private AtomicInteger reputation;

    public User(String name, String email){

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.reputation = new AtomicInteger(0);
    }


    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
    
    public int getReputation(){
        return reputation.get();
    }

    public void updateReputation(int reputation){
        this.reputation.addAndGet(reputation);
    }
     
}
