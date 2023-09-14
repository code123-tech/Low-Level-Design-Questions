package Questions.SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    public int numberOfDice;
    public int mini = 1;
    public int maxi = 6;

    public Dice(int numberOfDice){
        this.numberOfDice = numberOfDice;
    }

    public int rollDice(){
        int rollPoints = 0;
        for(int i = 0; i < numberOfDice; i++){
            rollPoints += ThreadLocalRandom.current().nextInt(mini, maxi+1);
        }
        return rollPoints;
    }
}
