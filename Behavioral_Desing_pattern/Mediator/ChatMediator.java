package Behavioral_Desing_pattern.Mediator;

// 1. Mediator interface
public interface ChatMediator {

    void sendMessage(User sender, String message);
    void notifyUsers(User sender, String event);
}
