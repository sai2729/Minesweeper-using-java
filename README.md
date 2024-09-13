# Minesweeper

This is a Java implementation of the classic Minesweeper game. The project is structured with different classes to manage the grid, cells, and gameplay. Players need to uncover tiles in a grid while avoiding hidden mines. The game provides options to reveal cells, flag potential mines, and manage game outcomes based on user actions.

## Project Structure

The project consists of the following key files:

- **Cell.java**: This class represents an individual cell in the Minesweeper grid. It handles the state of each cell, such as whether it contains a mine, is revealed, or is flagged by the player.
- **Grid.java**: This class manages the entire grid of cells. It initializes the grid, places mines, counts adjacent mines, and facilitates player interactions with the grid.
- **GamePlay.java**: This class handles the overall game logic, including player inputs, game state updates, win/loss conditions, and game flow.

## How to Play

1. The game grid is a set of cells. Some of these cells contain mines, while others are empty.
2. You need to uncover all the cells without mines to win the game.
3. If you uncover a cell with a mine, you lose the game.
4. You can flag a cell if you suspect it contains a mine.
5. The number on a revealed cell indicates how many mines are in the adjacent cells.
6. Continue revealing cells and flagging potential mines until all non-mine cells are uncovered.

## Running the Game

To run the Minesweeper game, follow these steps:

1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/minesweeper.git
   ```
2. Compile the Java files:
   ```bash
   javac GamePlay.java
   ```
3. Run the game:
   ```bash
   java GamePlay
   ```

## Future Enhancements
- Add a GUI for a more user-friendly experience.
- Include different difficulty levels (easy, medium, hard) based on grid size and number of mines.
- Add a timer to track the duration of the game.
- Implement save/load game functionality.

## Contributing
Feel free to contribute by submitting a pull request, reporting issues, or suggesting new features!

