package Questions.CircBuzz.models;

import Questions.CircBuzz.enums.WicketType;

public class Wicket {

    public WicketType wicketType;
    public Player takenBy;
    public Over over;
    public Ball ball;
    
    public Wicket(WicketType wicketType, Player takenBy, Over over, Ball ball) {
        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.over = over;
        this.ball = ball;
    }

}
