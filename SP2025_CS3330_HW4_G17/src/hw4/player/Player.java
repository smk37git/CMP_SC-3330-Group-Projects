package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {
	
	private Row row;
	private Cell cell;

	public Player(Row row, Cell cell) {
		// TODO Auto-generated constructor stub
		this.row = row;
		this.cell = cell;
		
	}
	
	public String toString() {
		return "Player [currentCell=" + cell + ", currentRow=" + row + "]";
	}
	
	public Row getCurrentRow() {
		return row;
	}
	
	public void setCurrentRow(Row row) {
		this.row = row;
	}
	
	public Cell getCurrentCell() {
		return cell;
	}
	
	public void setCurrentCell(Cell cell) {
		this.cell = cell;
	}

}
