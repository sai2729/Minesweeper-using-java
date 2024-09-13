package grid;

public class Cell {
	private boolean isMine;
    private boolean isRevealed;
    private int adjacentMines;

    public Cell() {
        this.isMine = false;
        this.isRevealed = false;
        this.adjacentMines = 0;
    }

    // Checks if the cell contains a mine.
    public boolean isMine() {
        return isMine;
    }

    // Sets the mine status of the cell.
    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    // Checks if the cell has been revealed.
    public boolean isRevealed() {
        return isRevealed;
    }

    // Sets the revealed status of the cell.
    public void setRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }

    // Gets the number of adjacent mines to this cell.
    public int getAdjacentMines() {
        return adjacentMines;
    }
    
    // Reveals the cell, marking it as revealed.
    public void reveal() {
        this.isRevealed = true;
    }

    // Sets the number of adjacent mines to this cell.
    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    @Override
    public String toString() {
        if (!isRevealed) {
            return ".";
        } else if (isMine) {
            return "@";
        } else if (adjacentMines > 0) {
            return String.valueOf(adjacentMines);
        } else {
            return " ";
        }
    }
}
