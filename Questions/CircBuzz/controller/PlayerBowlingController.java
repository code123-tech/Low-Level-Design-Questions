package Questions.CircBuzz.controller;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Questions.CircBuzz.models.Player;

public class PlayerBowlingController {

    Deque<Player> bowlers;
    Map<Player, Integer> oversCountPerBowler;
    Player currentBowler;

    public PlayerBowlingController(List<Player> bowlers){
        setBowlers(bowlers);
    }

    private void setBowlers(List<Player> bowlers){
        this.bowlers = new LinkedList<>();
        this.oversCountPerBowler = new HashMap<>();

        for(Player player : bowlers){
            this.bowlers.add(player);
            this.oversCountPerBowler.put(player, 0);
        }
    }

    public void getNextBowler(int maxOverPerBowler){
        
        Player player = bowlers.poll();
        
        if(oversCountPerBowler.get(player) + 1 == maxOverPerBowler){
            currentBowler = player;
        }else {
            currentBowler = player;
            bowlers.addLast(player);
            oversCountPerBowler.put(player, oversCountPerBowler.get(player) + 1);
        }
    }

    public Player getCurrentBowler(){
        return currentBowler;
    }

}
