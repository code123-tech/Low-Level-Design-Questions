package Questions.TicTaeToe.Models;

import Questions.TicTaeToe.enums.PlayingMarkType;

public class Player {
    private String name;
    private PlayingMarkType playingMarkType;

    public Player(String name, PlayingMarkType playingMarkType) {
        this.name = name;
        this.playingMarkType = playingMarkType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingMarkType getPlayingMarkType() {
        return playingMarkType;
    }

    public void setPlayingMarkType(PlayingMarkType playingMarkType) {
        this.playingMarkType = playingMarkType;
    }
}
