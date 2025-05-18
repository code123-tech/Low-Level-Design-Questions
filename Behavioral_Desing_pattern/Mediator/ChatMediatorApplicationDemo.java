package Behavioral_Desing_pattern.Mediator;

public class ChatMediatorApplicationDemo {

    public static void main(String[] args) {
        
        // Initialize mediator
        ChatRoomMediator mediator = new ChatRoomMediator();

        User alice = new User("Alice", mediator);
        User bob = new User("Bob", mediator);
        User charlie = new User("Charlie", mediator);

        mediator.addUser(alice);
        mediator.addUser(bob);
        mediator.addUser(charlie);

        System.out.println("=== Users Joining ===");
        alice.joinChat();
        bob.joinChat();
        charlie.joinChat();
        
        System.out.println("\n=== Users Sending Messages ===");
        alice.sendMessage("Hi everyone!");
        bob.sendMessage("Hey Alice, good to see you!");
        charlie.sendMessage("Hello all!");

        System.out.println("\n=== User Leaving ===");
        bob.leaveChat();

        System.out.println("\n=== Message After Bob Leaves ===");
        alice.sendMessage("Bob, you still there?");
    }
}
