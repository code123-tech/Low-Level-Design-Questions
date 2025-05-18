package Behavioral_Desing_pattern.Mediator;

// 2. Collegue class
public class User {

    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        System.out.println(name + " sends message: " + message);
        mediator.sendMessage(this, message);
    }

    public void receiveMessage(User sender, String message) {
        System.out.println(name + " received message from " + sender.getName() + ": " + message);
    }

    public void joinChat() {
        System.out.println(name + " joins the chat");
        mediator.notifyUsers(this, "joined");
    }

    public void leaveChat() {
        System.out.println(name + " leaves the chat");
        mediator.notifyUsers(this, "left");
        ((ChatRoomMediator)mediator).removeUser(this);
    }

    public void receiveNotification(User sender, String event) {
        System.out.println(name + " notified: " + sender.getName() + " " + event + " the chat");
    }

}
