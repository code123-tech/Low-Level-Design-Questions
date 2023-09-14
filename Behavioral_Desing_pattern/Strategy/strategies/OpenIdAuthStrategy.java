package Behavioral_Desing_pattern.Strategy.strategies;

public class OpenIdAuthStrategy implements AuthStrategy {
    @Override
    public void auth() {
        System.out.println("Authentication Using OpenId Auth strategy..");
    }
}
