package gameplay;

import java.util.Scanner;

import grid.Grid;

//The GamePlay class manages the flow and rules of the Minesweeper game.
public class GamePlay {
	private Grid grid;
    private final Scanner scanner = new Scanner(System.in);
    
    // startGame initiates the game process, including setting up the game and entering the game loop.
    public void startGame() {
        System.out.println("Welcome to Minesweeper!");
        int difficulty = getDifficultyFromUser();
        initializeGame(difficulty);
        playGame();
    }
    
    // getDifficultyFromUser prompts the user to select a difficulty level and validates the input.
    private int getDifficultyFromUser() {
        System.out.println("Select difficulty level:\n0: EASY\n1: MEDIUM\n2: HARD");
        int difficulty;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number! Please enter 0, 1, or 2.");
                scanner.next();
            }
            difficulty = scanner.nextInt();
            if (difficulty < 0 || difficulty > 2) {
                System.out.println("Please select a valid difficulty level.");
            }
        } while (difficulty < 0 || difficulty > 2);
        return difficulty;
    }

    // initializeGame sets up the game grid and places mines based on the selected difficulty.
    private void initializeGame(int difficulty) {
        grid = new Grid(difficulty);
        grid.calculateAdjacentMines();
    }

    // playGame contains the main game loop, processing user moves until the game ends.
    private void playGame() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            grid.display();
            System.out.println("Enter row and column numbers to reveal a cell (e.g., 3 5):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!grid.isValidCell(row, col)) {
                System.out.println("Invalid cell. Please try again.");
                continue;
            }

            continuePlaying = grid.revealCell(row, col);
            if (grid.isWin()) {
                System.out.println("Congratulations, you've won!");
                grid.display();
                break;
            } else if (!continuePlaying) {
                System.out.println("Boom! Game over.");
                grid.displayMines();
            }
        }
    }
}
