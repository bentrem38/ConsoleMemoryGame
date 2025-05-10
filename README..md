# Unicode Memory Game

This is a Java-based Memory Game developed as a school project at William & Mary. The game allows players to match pairs of hidden Unicode symbols with selectable difficulty levels and symbol sets, such as Cherokee and Vai.

## Features

- Multiple difficulty levels: Easy, Normal, Hard
- Unicode character sets (Cherokee, Vai)
- Turn-based input system with validation
- Leaderboard tracking with file-based persistence
- Object-oriented architecture with modular components

## Project Structure

- `Main.java` - Launches the game
- `MemoryGame.java` - Core game logic and control flow
- `GameBoard.java` - Manages board layout, turns, and output
- `GamePiece.java` and `CharacterGamePiece.java` - Symbol representation
- `Alphabet.java`, `CherAlphabet.java`, `VaiAlphabet.java` - Language-specific symbol sources
- `LeaderBoard.java` - Handles leaderboard file I/O

## How to Run

1. Clone the repository:
git clone https://github.com/bentrem38/ConsoleMemoryGame
cd memory-game
2. Compile the project (from the root or `src/` directory):
javac edu/wm/cs/cs301/memorygame/*.java
3. Run the game
java edu.wm.cs.cs301.memorygame.Main

4. Follow the prompts to:
- Select difficulty
- Choose a Unicode language set
- Enter your name
- Match pairs to complete the game

**Note:** Make sure your terminal supports UTF-8 encoding to display the symbols correctly.
