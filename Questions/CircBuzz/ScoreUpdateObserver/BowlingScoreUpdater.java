package Questions.CircBuzz.ScoreUpdateObserver;

import Questions.CircBuzz.enums.BallType;
import Questions.CircBuzz.models.Ball;

public class BowlingScoreUpdater implements ScoreUpdater{

    @Override
    public void update(Ball ball) {
        
        if(ball.ballNumber == 6 && ball.ballType == BallType.NORMAL){
            ball.bowledBy.bowlingCard.oversDelivered++;
        }

        
        ball.bowledBy.bowlingCard.runsGiven += ball.runType.getRunValue();
        
        if(ball.wicketDetails != null){
            ball.bowledBy.bowlingCard.wicketsTaken++;
        }

        if(ball.ballType == BallType.NOBALL){
            ball.bowledBy.bowlingCard.noBallCount++;
        }

        if(ball.ballType == BallType.WIDEBALL){
            ball.bowledBy.bowlingCard.wideBallCount++;
        }
    }

}
