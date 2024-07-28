# Tic-Tac-Toe Game

## Overview
This is a simple console-based Tic-Tac-Toe game implemented in Java. The game allows two players to play against each other or a single player to play against the computer. The game board is displayed after each move, and the game ends when a player wins or the board is full (a tie).

## Features
- Two game modes: Player vs Player and Player vs Computer.
- Validates player moves to ensure they are within the game board and not overwriting an existing mark.
- Displays the game board after each move.
- Detects and announces the winner or if the game is a tie.

## How to Play
1. **Start the game**: Run the `LaunchGame` class.
2. **Select game mode**: Choose between Player vs Player (Press 1) and Player vs Computer (Press 2).
3. **Enter player names**: Enter the names for both players in Player vs Player mode or your name in Player vs Computer mode.
4. **Make a move**: Players take turns to enter the row and column numbers where they want to place their mark (X or O).
5. **End of game**: The game will announce the winner or if the game is a tie.

## Code Structure
### Classes
1. **TicTacToe**: This class contains the game board and methods to initialize and display the board, place a mark, and check for winning conditions.
    - `initBoard()`: Initializes the game board with empty spaces.
    - `displayBoard()`: Displays the current state of the game board.
    - `placeMark(int row, int column, char mark)`: Places a mark on the board at the specified position.
    - `checkColWin()`, `checkRowWin()`, `checkDiagWin()`: Methods to check for winning conditions.

2. **Player**: An abstract class representing a generic player. It includes methods to make a move and check for valid moves.
    - `makeMove()`: Abstract method to be implemented by subclasses.
    - `isValidMove(int row, int column)`: Checks if a move is valid.
    - `checkDraw()`: Checks if the game is a draw.

3. **HumanPlayer**: A subclass of Player that represents a human player. Implements the `makeMove()` method to allow human input.
    - `makeMove()`: Prompts the human player to enter row and column numbers and places the mark if the move is valid.

4. **AIPlayer**: A subclass of Player that represents an AI player. Implements the `makeMove()` method to randomly choose a valid position on the board.
    - `makeMove()`: Randomly selects a row and column for the AI's move.

5. **LaunchGame**: The main class that initializes the game, handles user input, and manages the game loop.
    - `main(String[] args)`: The entry point of the program. Handles game setup, player turns, and checks for win conditions or a draw.

## Concepts Used
- **OOP (Object-Oriented Programming)**: The game is designed using OOP principles with classes representing the game board, players, and the main game logic.
- **Inheritance and Polymorphism**: `HumanPlayer` and `AIPlayer` inherit from the abstract `Player` class and implement the `makeMove()` method.
- **Encapsulation**: The game logic and state are encapsulated within their respective classes.
- **Randomization**: The AI player uses randomization to select its moves.
- **User Input Handling**: The game uses the `Scanner` class to handle user input and ensure valid moves are made.
- **Game Loop**: The main game loop runs until a player wins or the game is a tie, updating and displaying the board after each move.

## How to Run
1. Ensure you have Java installed on your machine.
2. Clone the repository to your local machine.
3. Navigate to the project directory.
4. Compile the Java files:
    ```sh
    javac com/game/*.java
    ```
5. Run the game:
    ```sh
    java com.game.LaunchGame
    ```

## Future Enhancements
- Implement a more intelligent AI using a minimax algorithm.
- Add a graphical user interface (GUI) for better user experience.
- Allow for custom board sizes.
