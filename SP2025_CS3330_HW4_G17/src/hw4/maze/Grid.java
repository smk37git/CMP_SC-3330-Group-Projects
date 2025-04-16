package hw4.maze;

import java.util.ArrayList;

public class Grid {
	
	/* Grid Class Row */
	private ArrayList<Row> rows; 

	/* Assign Rows */
	public Grid(ArrayList<Row> rows) {
		this.rows = rows;
	}
	
	/* Getters and Setters */
	public ArrayList<Row> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}
	
	/* To String */
	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}
}
