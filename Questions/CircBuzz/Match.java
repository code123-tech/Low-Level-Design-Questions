package Questions.CircBuzz;

import java.util.Date;

import Questions.CircBuzz.models.Inning;
import Questions.CircBuzz.models.Team;
import Questions.CircBuzz.models.MatchTypes.MatchType;

public class Match {

    Team teamA;
    Team teamB;
    Date matchDate;
    String venue;
    Team tossWinner;
    Inning[] innings;
    MatchType matchType;

    public Match(Team teamA, Team teamB, Date matchDate, String venue, MatchType matchType){

        this.teamA = teamA;
        this.teamB = teamB;
        this.matchDate = matchDate;
        this.venue = venue;
        this.matchType = matchType;
        innings = new Inning[2];
    }

    public void startMatch(){

        this.tossWinner = toss(teamA, teamB);

        for(int inning = 1; inning <= 2; inning++){

            Inning inningDetails;
            Team bowlingTeam;
            Team battingTeam;

            boolean isChasing = false;
            
            if(inning == 1){
                battingTeam = tossWinner;
                bowlingTeam = (tossWinner.getTeamName().equals(teamA.getTeamName())) ? teamB : teamA;

                inningDetails = new Inning(battingTeam, bowlingTeam, matchType);
                inningDetails.start(-1);
            }

            else {
                bowlingTeam = tossWinner;
                battingTeam = tossWinner.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;

                inningDetails = new Inning(battingTeam, bowlingTeam, matchType);
                inningDetails.start(innings[0].getTotalRuns());

                if(bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()){
                    bowlingTeam.isWinner = true;
                }
            }

            innings[inning - 1] = inningDetails;

            System.out.println();
            System.out.println("INNING " + inning + " -- totalRun: " + battingTeam.getTotalRuns());
            System.out.println("--- Batting ScoreCard : " + battingTeam.getTeamName() + "---");
            battingTeam.printBattingScoreCard();

            System.out.println();
            System.out.println("--- Bowling ScoreCard : " + bowlingTeam.getTeamName() + "---");
            bowlingTeam.printBowlingScoreCard();
        }

        System.out.println();
        if(teamA.isWinner){
            System.out.println("Winner: " + teamA.getTeamName());
        }
        else{
            System.out.println("Winner: " + teamB.getTeamName());
        }
    }

    private Team toss(Team teamA, Team teamB){

        if(Math.random() < 0.5){
            return teamA;
        }

        return teamB;
    }

}
