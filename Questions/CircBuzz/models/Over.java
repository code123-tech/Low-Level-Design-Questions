package Questions.CircBuzz.models;

import java.util.ArrayList;
import java.util.List;

import Questions.CircBuzz.enums.BallType;

public class Over {

    int overNumber;
    Player bowledBy;
    List<Ball> balls;
    int extraBallsCount;

    public Over(int overNumber, Player player){
        this.overNumber = overNumber;
        this.bowledBy = player;
        this.balls = new ArrayList<>();
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception{

        int ballCount = 1;
        while (ballCount <= 6){

            Ball ball = new Ball(ballCount);
            ball.completeBall(battingTeam, bowlingTeam, this);

            if(ball.ballType == BallType.NORMAL){
                
                balls.add(ball);
                ballCount++;
                if(ball.wicketDetails != null){
                    battingTeam.chooseNextBatsman();
                }

                if(runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin){
                    battingTeam.isWinner = true;
                    return true;
                }
            }else {
                extraBallsCount++;
            }
        }

        return false;
    }

}
