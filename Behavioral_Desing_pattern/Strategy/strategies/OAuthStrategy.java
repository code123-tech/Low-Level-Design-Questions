package Behavioral_Desing_pattern.Strategy.strategies;

public class OAuthStrategy implements AuthStrategy {
    @Override
    public void auth() {
        System.out.println("Authentication Using OAuth strategy..");
    }
}
