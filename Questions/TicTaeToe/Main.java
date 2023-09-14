package Questions.TicTaeToe;

import Questions.TicTaeToe.Models.Player;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player wonPlayer = game.startGame();
        if(wonPlayer == null){
            System.out.println("Game is Tie.");
        }else{
            System.out.println("Game is won by " + wonPlayer.getName());
        }
    }
}
