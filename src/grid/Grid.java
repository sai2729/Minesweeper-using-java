package grid;

import java.util.Random;

//The Grid class represents the Minesweeper game grid.
public class Grid {
    private final int size = 9;
    private Cell[][] cells;
    private final int numMines;

    // Constructor initializes the grid based on the selected difficulty level.
    public Grid(int difficulty) {
        cells = new Cell[size][size];
        numMines = calculateMines(difficulty);
        initializeCells();
        placeMines();
    }
    // Initializes each cell in the grid to an empty Cell object.
    private void initializeCells() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    // Calculates the number of mines based on the chosen difficulty level.
    private int calculateMines(int difficulty) {
        switch (difficulty) {
            case 0: // EASY
                return size; // 9 mines for easy level
            case 1: // MEDIUM
                return size + (1 * 3); // 12 mines for medium level
            case 2: // HARD
                return size + (2 * 3); // 15 mines for hard level
            default:
                return size; // Default size
        }
    }

    // Places the determined number of mines randomly on the grid.
    public void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            if (!cells[row][col].isMine()) {
                cells[row][col].setMine(true);
                minesPlaced++;
            }
        }
    }

    // Calculates the number of adjacent mines for each cell.
    public void calculateAdjacentMines() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!cells[i][j].isMine()) {
                    int mines = countAdjacentMines(i, j);
                    cells[i][j].setAdjacentMines(mines);
                }
            }
        }
    }
    
    // Counts the number of mines adjacent to a given cell.
    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int newRow = row + i;
                int newCol = col + j;
                if (isValidCell(newRow, newCol) && cells[newRow][newCol].isMine()) {
                    count++;
                }
            }
        }
        return count;
    }

    // Reveals the cell at the specified row and column.
    public boolean revealCell(int row, int col) {
        if (!isValidCell(row, col) || cells[row][col].isRevealed()) {
            return true;
        }

        cells[row][col].reveal();

        if (cells[row][col].isMine()) {
            return false;
        }

        if (cells[row][col].getAdjacentMines() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    int newRow = row + i;
                    int newCol = col + j;
                    if (isValidCell(newRow, newCol) && !cells[newRow][newCol].isRevealed()) {
                        revealCell(newRow, newCol);
                    }
                }
            }
        }

        return true;
    }

    // Checks if a specified cell coordinate is within the grid bounds.
    public boolean isValidCell(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    // Displays the current state of the grid to the player.
    public void display() {
    	System.out.print("  ");
    	for( int i=0; i < size; i++) {
    		System.out.print(i+" ");
    	}
    	System.out.println();
        for (int i = 0; i < size; i++) {
        	System.out.print(i+" ");
            for (int j = 0; j < size; j++) {
                if (!cells[i][j].isRevealed()) {
                    System.out.print(". ");
                } else if (cells[i][j].isMine()) {
                    System.out.print(". ");
                } else {
                    System.out.print(cells[i][j].getAdjacentMines() + " ");
                }
            }
            System.out.println();
        }
    }
    
    // Displays the grid with all mines revealed, used when the game is over.
    public void displayMines() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].isMine()) {
                    System.out.print("@ ");
                } else {
                    System.out.print(cells[i][j].getAdjacentMines() + " ");
                }
            }
            System.out.println();
        }
    }

    // Determines if the player has won by revealing all non-mine cells.
    public boolean isWin() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!cells[i][j].isMine() && !cells[i][j].isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }

}
