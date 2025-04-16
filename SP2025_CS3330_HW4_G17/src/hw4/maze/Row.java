package hw4.maze;

import java.util.ArrayList;

public class Row {
	
	private ArrayList<Cell> cells;
	
	/* Assign Cells */
	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	/* Getters and Setter */
	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
	/* To String */
	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}
}
