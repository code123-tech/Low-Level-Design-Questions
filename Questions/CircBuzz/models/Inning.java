package Questions.CircBuzz.models;

import java.util.ArrayList;
import java.util.List;

import Questions.CircBuzz.models.MatchTypes.MatchType;

public class Inning {

    Team battingTeam;
    Team bowlingTeam;
    MatchType matchType;
    List<Over> overs;

    public Inning(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        this.overs = new ArrayList<>();
    }

    public void start(int runsToWin){

        try{
            battingTeam.chooseNextBatsman();
        }catch (Exception e){
            System.out.println("No Batsman available to play");
        }

        int noOfOvers = matchType.noOfOvers();
        for(int overNumber = 1;  overNumber <= noOfOvers; overNumber++){

            bowlingTeam.nextBowler(matchType.maxOverCountBowlers());

            Over over = new Over(overNumber, bowlingTeam.getCurrentBowler());
            overs.add(over);

            try {
                boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
                if(won) break;
            } catch (Exception e){
                break;
            }

            Player striker = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(striker);
       }
    }

    public int getTotalRuns(){
        return battingTeam.getTotalRuns();
    }

}
