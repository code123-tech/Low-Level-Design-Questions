package Behavioral_Desing_pattern.Strategy.strategies;

public class BasicAuthStrategy implements AuthStrategy {
    @Override
    public void auth() {
        System.out.println("Authentication Using Basic auth strategy..");
    }
}
