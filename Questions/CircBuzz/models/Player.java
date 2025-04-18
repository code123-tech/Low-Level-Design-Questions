package Questions.CircBuzz.models;

import Questions.CircBuzz.enums.PlayerType;
import Questions.CircBuzz.models.ScoreCard.BattingScoreCard;
import Questions.CircBuzz.models.ScoreCard.BowlingScoreCard;

public class Player {

    public Person person;
    public PlayerType playerType;
    public BattingScoreCard battingCard;
    public BowlingScoreCard bowlingCard;

    public Player(Person person, PlayerType playerType){

        this.person = person;
        this.playerType = playerType;
        this.battingCard = new BattingScoreCard();
        this.bowlingCard = new BowlingScoreCard();
    }

    public void printBattingScoreCard(){
        
        System.out.println("PlayerName: " + person.name + " -- totalRuns: " + battingCard.totalRuns 
            + " -- totalBallsPlayed: " + battingCard.totalBowlsPlayed + " -- 4s: " + battingCard.totalFours
            + " -- 6s: " + battingCard.totalSixes + " -- outBy: " + ((battingCard.wicketDetails != null) ? battingCard.wicketDetails.takenBy.person.name : "Not Out"));
        
    }

    public void printBowlingScoreCard(){
        
        System.out.println("PlayerName: " + person.name + " -- totalOversThrown: " + bowlingCard.oversDelivered 
            + " -- totalRunsGiven: " + bowlingCard.runsGiven + " -- wicketsTaken: " + bowlingCard.wicketsTaken);
    }

}
