package Questions.CircBuzz.models;

import java.util.List;
import java.util.Queue;

import Questions.CircBuzz.controller.PlayerBattingController;
import Questions.CircBuzz.controller.PlayerBowlingController;

public class Team {

    public String teamName;
    public Queue<Player> playing11;
    public List<Player> extraPlayers;
    public boolean isWinner;
    public PlayerBattingController battingController;
    public PlayerBowlingController bowlingController;

    public Team(String teamName, Queue<Player> playing11, List<Player> extraPlayers, List<Player> bowlers){
        this.teamName = teamName;
        this.playing11 = playing11;
        this.extraPlayers = extraPlayers;
        this.battingController = new PlayerBattingController(playing11);
        this.bowlingController = new PlayerBowlingController(bowlers);
    }

    public String getTeamName() {
        return teamName;
    }

    public void chooseNextBatsman() throws Exception{
        battingController.getNextPlayer();
    }
    
    public void nextBowler(int maxOverCountPerBowler){
        bowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public Player getStriker(){
        return battingController.getStriker();
    }

    public Player getNonStriker(){
        return battingController.getNonStriker();
    }

    public void setStriker(Player player){
        battingController.setStriker(player);
    }

    public void setNonStriker(Player player){
        battingController.setNonStriker(player);
    }

    public Player getCurrentBowler(){
        return bowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard(){
        
        for(Player player: playing11){
            player.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard(){
        
        for(Player player: playing11){

            if(player.bowlingCard.oversDelivered > 0){
                player.printBowlingScoreCard();
            }
        }
    }

    public int getTotalRuns(){

        int totalRuns = 0;
        for(Player player: playing11){
            totalRuns += player.battingCard.totalRuns;
        }

        return totalRuns;
    }

}
