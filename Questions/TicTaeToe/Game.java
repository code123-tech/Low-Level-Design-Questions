package Questions.TicTaeToe;

import Questions.TicTaeToe.Models.Board;
import Questions.TicTaeToe.Models.Player;
import Questions.TicTaeToe.enums.PlayingMarkType;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    private Board board;
    private Deque<Player> players = new LinkedList<>();

    public Game(){
        int size = 3;
        board = new Board(size);
        int numberOfPlayers = 2;
        players.add(new Player("P1", PlayingMarkType.O));
        players.add(new Player("P2", PlayingMarkType.X));
    }

    public Player startGame(){
        Boolean isGameNotWon = true;

        while(isGameNotWon){
            Player playerTurn = players.removeFirst();
            this.board.printBoard();

            if(!this.board.showEmptyCells()){
                isGameNotWon = false;
                continue;
            }

            System.out.println("Player: " + playerTurn.getName() +" Enter row, col (Seperated by comma): ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] inputs = s.split(",");
            int row = Integer.parseInt(inputs[0]);
            int col = Integer.parseInt(inputs[1]);

            boolean isMarkAdded = this.board.placeMarkOnBoard(row, col, playerTurn.getPlayingMarkType());
            if(!isMarkAdded){
                this.players.addFirst(playerTurn);
                continue;
            }
            this.players.addLast(playerTurn);

            boolean isCurrentPlayerWinner = checkWinner(row,col,playerTurn.getPlayingMarkType());
            if(isCurrentPlayerWinner){
                return playerTurn;
            }
        }
        return null;
    }
    private boolean checkWinner(int row, int col, PlayingMarkType playingMarkType){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<this.board.getSize();i++) {

            if(this.board.getCell(row, i) == null || !this.board.getCell(row, i).equals(playingMarkType)) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<this.board.getSize();i++) {

            if(this.board.getCell(i,col) == null || !this.board.getCell(i,col).equals(playingMarkType)) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<this.board.getSize();i++,j++) {
            if (this.board.getCell(i, j) == null || !this.board.getCell(i, j).equals(playingMarkType)) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=this.board.getSize()-1; i<this.board.getSize();i++,j--) {
            if (this.board.getCell(i, j) == null || this.board.getCell(i, j).equals(playingMarkType)) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
