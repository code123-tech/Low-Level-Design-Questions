package Questions.SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Player winner;

    public Game(){
        initializeGame();
    }

    private void initializeGame(){
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        addPlayers();
    }

    private void addPlayers(){
        players.add(new Player("p1", 0));
        players.add(new Player("p2", 0));
    }

    public void startGame(){
        while (winner == null){
            Player playerTurn = findPlayerTurn();
            System.out.println("Current player id is: " + playerTurn.id + " Current position is: " + playerTurn.currentPosition);

            int diceNumbers = dice.rollDice();

            int playerNextPosition = playerTurn.currentPosition + diceNumbers;
            playerNextPosition = jumpCheck(playerNextPosition);
            playerTurn.currentPosition = playerNextPosition;

            System.out.println("Current player id is: " + playerTurn.id + " Next position is: " + playerTurn.currentPosition);

            if(playerNextPosition >= board.cells.length*board.cells.length){
                winner = playerTurn;
            }
        }
    }

    private int jumpCheck(int position){
        if(position > board.cells.length*board.cells.length - 1){
            return position;
        }

        Cell cell = board.getCell(position);
        if(cell.jump != null && cell.jump.start == position){
            String jumpBy = cell.jump.start > cell.jump.end ? "snake" : "ladder";
            System.out.println("Jump is: " +  jumpBy);
            return cell.jump.end;
        }
        return position;
    }
    private Player findPlayerTurn(){
        Player playerTurn = players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }
}
