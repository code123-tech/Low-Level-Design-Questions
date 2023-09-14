package Behavioral_Desing_pattern.Strategy;

import Behavioral_Desing_pattern.Strategy.strategies.BasicAuthStrategy;
import Behavioral_Desing_pattern.Strategy.strategies.OAuthStrategy;
import Behavioral_Desing_pattern.Strategy.strategies.OpenIdAuthStrategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------Using Strategy Design Pattern------------------");
        BasicAuthStrategy basicAuthStrategy = new BasicAuthStrategy();
        OAuthStrategy oAuthStrategy = new OAuthStrategy();
        OpenIdAuthStrategy openIdAuthStrategy = new OpenIdAuthStrategy();

        AuthProgram authProgram = new AuthProgram();
        authProgram.authenticate(); // when no auth strategy is taken.

        authProgram.useStrategy(basicAuthStrategy);
        authProgram.authenticate();

        authProgram.useStrategy(oAuthStrategy);
        authProgram.authenticate();

        authProgram.useStrategy(openIdAuthStrategy);
        authProgram.authenticate();
    }
}
