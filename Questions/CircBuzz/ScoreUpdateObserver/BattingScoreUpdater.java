package Questions.CircBuzz.ScoreUpdateObserver;

import Questions.CircBuzz.enums.RunType;
import Questions.CircBuzz.models.Ball;

public class BattingScoreUpdater implements ScoreUpdater{

    @Override
    public void update(Ball ball) {

        int run = 0;
        RunType ballRunType = ball.runType;

        if(RunType.ONE == ballRunType){
            run = 1;
        }
        else if(RunType.TWO == ballRunType){
            run = 2;
        }
        else if(RunType.THREE == ballRunType){
            run = 3;
        }
        else if(RunType.FOUR == ballRunType){
            run = 4;
            ball.playedBy.battingCard.totalFours++;
        }
        else if(RunType.SIX == ballRunType){
            run = 6;
            ball.playedBy.battingCard.totalSixes++;
        }

        ball.playedBy.battingCard.totalRuns += run;
        ball.playedBy.battingCard.totalBowlsPlayed++;

        if(ball.wicketDetails != null){
            ball.playedBy.battingCard.wicketDetails = ball.wicketDetails;
        }
    }

}
