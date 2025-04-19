package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {
	
	/*
	 * Agent row and cell
	 */
	private Row row;
	private Cell cell;

	/*
	 * Current agent row and cell
	 */
	public Player(Row row, Cell cell) {
		// TODO Auto-generated constructor stub
		this.row = row;
		this.cell = cell;
		
	}
	
	/*
	 * To string
	 */
	public String toString() {
		return "Player [currentCell=" + cell + ", currentRow=" + row + "]";
	}
	
	/*
	 * Gets agent's current Row
	 */
	public Row getCurrentRow() {
		return row;
	}
	
	/*
	 * Sets agent's current Row
	 */
	public void setCurrentRow(Row row) {
		this.row = row;
	}
	
	/*
	 * Gets agent's current Cell
	 */
	public Cell getCurrentCell() {
		return cell;
	}
	
	/*
	 * Sets agent's current Cell
	 */
	public void setCurrentCell(Cell cell) {
		this.cell = cell;
	}

}
