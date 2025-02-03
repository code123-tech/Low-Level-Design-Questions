package Questions.TicTaeToe.Models;

import Questions.TicTaeToe.enums.PlayingMarkType;

public class Board {
    private PlayingMarkType[][] board;
    private int size;

    public Board(int size){
        this.size = size;
        this.board = new PlayingMarkType[size][size];
    }

    public boolean placeMarkOnBoard(int row, int col, PlayingMarkType playingMarkType){
        if(row < 0 || row >= this.size || col < 0 || col >= size){
            System.out.println("Invalid row: " + row + ", column: " + col + " number, try again!!");
            return false;
        }
        if(this.board[row][col] != null){
            System.out.println("Cell is already occupied with mark " + this.board[row][col].name() + " , try again!!");
            return false;
        }
        this.board[row][col] = playingMarkType;
        return true;
    }

    public boolean showEmptyCells(){
        System.out.println("List of empty slots are as follows:");
        Boolean isEmptyCellFound = false;

        for(int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if(this.board[i][j] == null){
                    System.out.println("row: " + i + ", col: " + j);
                    isEmptyCellFound = true;
                }
            }
        }
        if(!isEmptyCellFound){
            System.out.println("No Empty cell found.");
        }
        return isEmptyCellFound;
    }

    public void printBoard(){
        System.out.println("____________________");
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.board[i][j] != null) {
                    System.out.print("  " + this.board[i][j].name() + " ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public PlayingMarkType getCell(int row, int col){
        return this.board[row][col];
    }

    public int getSize() {
        return size;
    }
}
