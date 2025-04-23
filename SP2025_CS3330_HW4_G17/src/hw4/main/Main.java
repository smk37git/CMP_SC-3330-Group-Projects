package hw4.main;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Generate a random game
        Game game = new Game(5); // Or any size between 3 and 7
        Grid grid = game.getGrid();

        // Place player at bottom-right corner initially
        int lastIndex = grid.getRows().size() - 1;
        Row startRow = grid.getRows().get(lastIndex);
        Cell startCell = startRow.getCells().get(lastIndex);
        Player player = new Player(startRow, startCell);

        // Game start
        System.out.println("Welcome to the maze!");
        boolean isRunning = true;

        while (isRunning) {
            printGrid(grid, player);
            System.out.print("Enter move (UP/DOWN/LEFT/RIGHT): ");
            String input = scanner.nextLine().toUpperCase();

            try {
                Movement move = Movement.valueOf(input);
                boolean result = game.play(move, player);
                if (!result) {
                    System.out.println("Can't move that way!");
                } else if (move == Movement.LEFT && player.getCurrentRow().getCells().indexOf(player.getCurrentCell()) == 0 &&
                           player.getCurrentCell().getLeft().toString().equals("EXIT")) {
                    System.out.println("You escaped the grid! Congratulations!");
                    isRunning = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid direction. Try again.");
            }

        }

        scanner.close();
	}
	
	private static void printGrid(Grid grid, Player player) {
        System.out.println("\nCurrent Grid:");
        for (Row row : grid.getRows()) {
            for (Cell cell : row.getCells()) {
                if (player.getCurrentRow() == row && player.getCurrentCell() == cell) {
                    System.out.print(" A ");
                } else if (cell.getLeft().toString().equals("EXIT")) {
                    System.out.print(" E ");
                } else {
                    System.out.print(" S ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
