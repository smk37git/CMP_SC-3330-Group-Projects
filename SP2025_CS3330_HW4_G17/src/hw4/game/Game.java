package hw4.game;
import java.util.ArrayList;
import java.util.Random;

import hw4.maze.*;
import hw4.player.*;

public class Game {

	private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }

    public Game(int gridSize) {
        this.grid = createRandomGrid(gridSize);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public boolean play(Movement move, Player player) {
        if (move == null || player == null) return false;

        ArrayList<Row> rows = grid.getRows();
        int rowIndex = rows.indexOf(player.getCurrentRow());
        int colIndex = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());

        try {
            switch (move) {
                case UP:
                    if (player.getCurrentCell().getUp() == CellComponents.APERTURE ||
                        player.getCurrentCell().getUp() == CellComponents.EXIT) {
                        player.setCurrentRow(rows.get(rowIndex - 1));
                        player.setCurrentCell(rows.get(rowIndex - 1).getCells().get(colIndex));
                        return true;
                    }
                    break;
                case DOWN:
                    if (player.getCurrentCell().getDown() == CellComponents.APERTURE ||
                        player.getCurrentCell().getDown() == CellComponents.EXIT) {
                        player.setCurrentRow(rows.get(rowIndex + 1));
                        player.setCurrentCell(rows.get(rowIndex + 1).getCells().get(colIndex));
                        return true;
                    }
                    break;
                case LEFT:
                    if (player.getCurrentCell().getLeft() == CellComponents.APERTURE) {
                        player.setCurrentCell(player.getCurrentRow().getCells().get(colIndex - 1));
                        return true;
                    } else if (player.getCurrentCell().getLeft() == CellComponents.EXIT && colIndex == 0) {
                        return true;
                    }
                    break;
                case RIGHT:
                    if (player.getCurrentCell().getRight() == CellComponents.APERTURE ||
                        player.getCurrentCell().getRight() == CellComponents.EXIT) {
                        player.setCurrentCell(player.getCurrentRow().getCells().get(colIndex + 1));
                        return true;
                    }
                break;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        return false;
    }
    
    
    public Grid createRandomGrid(int size) {
        if (size < 3 || size > 7) return null;

        Random rand = new Random();
        ArrayList<Row> rows = new ArrayList<>();
        int exitRow = rand.nextInt(size);

        // Build empty grid first
        Cell[][] gridCells = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
            	CellComponents up, down, left, right;

                // Sync from above
                if (i > 0) up = gridCells[i - 1][j].getDown();
                else up = CellComponents.WALL;

                // Sync from left
                if (j > 0) left = gridCells[i][j - 1].getRight();
                else left = (i == exitRow) ? CellComponents.EXIT : CellComponents.WALL;

                // Generate right/down randomly — only if not at boundary
                right = (j < size - 1) ? randComponent(rand) : CellComponents.WALL;
                down = (i < size - 1) ? randComponent(rand) : CellComponents.WALL;
                
                // Ensure at least one aperture
                if (up != CellComponents.APERTURE && down != CellComponents.APERTURE &&
                    left != CellComponents.APERTURE && right != CellComponents.APERTURE) {
                    int forced = rand.nextInt(2);
                    switch (forced) {
                        case 0 -> down = CellComponents.APERTURE;
                        case 1 -> right = CellComponents.APERTURE;
                    }
                }

                gridCells[i][j] = new Cell(left, right, up, down);
            }
        }

        for (int i = 0; i < size; i++) {
            ArrayList<Cell> rowCells = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                rowCells.add(gridCells[i][j]);
            }
            rows.add(new Row(rowCells));
        }
        return new Grid(rows);
        
        
    }

    private CellComponents randComponent(Random rand) {
        return rand.nextBoolean() ? CellComponents.WALL : CellComponents.APERTURE;
    }

    @Override
    public String toString() {
        return "Game [grid=" + grid + "]";
    }
    
}
