package Behavioral_Desing_pattern.Mediator;

import java.util.ArrayList;
import java.util.List;

// 3. Concrete Mediator
public class ChatRoomMediator implements ChatMediator{

    private List<User> users;

    public ChatRoomMediator() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    @Override
    public void sendMessage(User sender, String message){

        for (User user : users) {
            if (user != sender) { // Don't send to the sender
                user.receiveMessage(sender, message);
            }
        }
    }

    @Override
    public void notifyUsers(User sender, String event){
        for (User user : users) {
            if (user != sender) {
                user.receiveNotification(sender, event);
            }
        }
    }

}
