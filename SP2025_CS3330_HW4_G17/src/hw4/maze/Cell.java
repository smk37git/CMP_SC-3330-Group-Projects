package hw4.maze;

public class Cell {
	
	/* Cell Class Movements */
	private CellComponents up;
	private CellComponents down;
	private CellComponents left;
	private CellComponents right;
	
	/* Access For Cell Movement */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	
	/* To String */
	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}

	/* Getters and Setters */
	public CellComponents getUp() {
		return up;
	}

	public void setUp(CellComponents up) {
		if (up == null) {
			this.up = CellComponents.WALL;
		} else {
			this.up = up;
		}
	}

	public CellComponents getDown() {
		return down;
	}

	public void setDown(CellComponents down) {
		if (down == null) {
			this.down = CellComponents.WALL;
		} else {
			this.down = down;
		}
	}

	public CellComponents getLeft() {
		return left;
	}

	public void setLeft(CellComponents left) {
		if (left == null) {
			this.left = CellComponents.WALL;
		} else {
			this.left = left;
		}
	}

	public CellComponents getRight() {
		return right;
	}

	public void setRight(CellComponents right) {
		if (right == null) {
			this.right = CellComponents.WALL;
		} else {
			this.right = right;
		}
	}
}
