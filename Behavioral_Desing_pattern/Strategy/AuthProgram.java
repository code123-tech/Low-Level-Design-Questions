package Behavioral_Desing_pattern.Strategy;

import Behavioral_Desing_pattern.Strategy.strategies.AuthStrategy;

public class AuthProgram {
    private AuthStrategy authStrategy;

    public void useStrategy(AuthStrategy authStrategy){
        this.authStrategy = authStrategy;
    }

    public void authenticate(){
        if(this.authStrategy == null){
            System.out.println("No Authentication strategy set.");
            return;
        }
        this.authStrategy.auth();
    }
}
