package Questions.SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    public Cell[][] cells;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders){
        initializeCells(boardSize);
        addSnakesAndLadders(numberOfSnakes, numberOfLadders);
    }

    private void initializeCells(int boardSize){
        cells = new Cell[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                cells[i][j] = new Cell();
            }
        }
    }

    private void addSnakesAndLadders(int numberOfSnakes, int numberOfLadders){
        if(cells == null){
            throw new RuntimeException("Cells are not initialized..");
        }
        int boardSize = this.cells.length;

        while(numberOfSnakes > 0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1, boardSize*boardSize-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, boardSize*boardSize-1);
            if(snakeTail >= snakeHead || ((snakeHead/boardSize) == (snakeTail/boardSize))) continue;

            Jump jump = new Jump(snakeHead, snakeTail);

            Cell cell = getCell(snakeHead);
            cell.jump = jump;
            numberOfSnakes--;
        }

        while(numberOfLadders > 0){
            int ladderStart = ThreadLocalRandom.current().nextInt(1, boardSize*boardSize-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, boardSize*boardSize-1);
            if(ladderStart >= ladderEnd || ((ladderStart/boardSize) == (ladderEnd/boardSize))) continue;

            Jump jump = new Jump(ladderStart, ladderEnd);

            Cell cell = getCell(ladderStart);
            cell.jump = jump;
            numberOfLadders--;
        }
    }

    public Cell getCell(int position){
        int boardSize = cells.length;
        int row = position/boardSize;
        int col = position%boardSize;
        return cells[row][col];
    }
}
