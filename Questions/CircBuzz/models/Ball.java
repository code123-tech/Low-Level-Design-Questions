package Questions.CircBuzz.models;

import java.util.ArrayList;
import java.util.List;

import Questions.CircBuzz.ScoreUpdateObserver.BattingScoreUpdater;
import Questions.CircBuzz.ScoreUpdateObserver.BowlingScoreUpdater;
import Questions.CircBuzz.ScoreUpdateObserver.ScoreUpdater;
import Questions.CircBuzz.enums.BallType;
import Questions.CircBuzz.enums.RunType;
import Questions.CircBuzz.enums.WicketType;

public class Ball {

    public int ballNumber;
    public BallType ballType;
    public RunType runType;
    public Player playedBy;
    public Player bowledBy;
    public Wicket wicketDetails;
    public List<ScoreUpdater> updaters = new ArrayList<>();

    public Ball(int ballNumber){

        this.ballNumber = ballNumber;
        updaters.add(new BowlingScoreUpdater());
        updaters.add(new BattingScoreUpdater());
    }

    public void completeBall(Team battingTeam, Team bowlingTeam, Over over){

        this.playedBy = battingTeam.getStriker();
        this.bowledBy = over.bowledBy;

        this.ballType = BallType.NORMAL;

        if(isWicketTaken()){

            this.runType = RunType.ZERO;
            this.wicketDetails = new Wicket(WicketType.BOLD, bowlingTeam.getCurrentBowler(), over, this);
            battingTeam.setStriker(null);
        } else {

            this.runType = getRunType();
            
            if(runType == RunType.ONE || runType == RunType.THREE){

                Player temp = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                battingTeam.setNonStriker(temp);
            }
        }

        notifyUpdaters(this);
    }

    private void notifyUpdaters(Ball ball){

        for(ScoreUpdater updater: updaters){
            updater.update(ball);
        }
    }

    private RunType getRunType(){
        
        double val = Math.random();
        if (val <= 0) return RunType.ZERO;
        if(val <= 0.1) return RunType.ONE;
        else if(val <= 0.2) return RunType.TWO;
        else if(val <= 0.3) return RunType.THREE;
        else if(val <= 0.4) return RunType.FOUR;
        else return RunType.SIX;
    }

    private boolean isWicketTaken(){
        return Math.random() < 0.2;
    }

}   
