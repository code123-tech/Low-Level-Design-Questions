package Questions.CircBuzz.controller;

import java.util.LinkedList;
import java.util.Queue;

import Questions.CircBuzz.models.Player;

public class PlayerBattingController {

    Queue<Player> yetToPlay;
    Player striker;
    Player nonStriker;

    public PlayerBattingController(Queue<Player> yetToPlay) {
        this.yetToPlay = new LinkedList<>();
        this.yetToPlay.addAll(yetToPlay);
    }

    public void getNextPlayer() throws Exception{

        if(this.yetToPlay.isEmpty()){
            throw new Exception();
        }

        if(striker == null){
            striker = this.yetToPlay.poll();
        }

        if(nonStriker == null){
            nonStriker = this.yetToPlay.poll();
        }
    }

    public Player getStriker(){
        return striker;
    }

    public Player getNonStriker(){
        return nonStriker;
    }

    public void setStriker(Player player){
        this.striker = player;
    }

    public void setNonStriker(Player player){
        this.nonStriker = player;
    }

}
