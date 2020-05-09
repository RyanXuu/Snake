/**
 * This class provides the constructor for the Position object, various
 * getter/setter methods for instance variable positionRow and positionColumn, and a boolean method
 * to check if two Position objects are equal. The Position object will be used extensively in class
 * BoardGame to construct the board
 * @RyanXu CS1027 
 */

public class Position {
	
	/** Instance variables */
	private int positionRow;
	private int positionColumn;

	/** Constructor
	 * Initializes the Position object using the given row and column arguments */
	public Position(int row, int column) {
		this.positionRow = row;
		this.positionColumn = column;
	}
	
	/** Getter methods */
	
	/* Returns positionRow of object Position */
	public int getRow() {
		return this.positionRow;
	}
	
	/* Returns positionColumn of object Position */
	public int getCol() {
		return this.positionColumn;
	}
	
	/** Setter methods */
	
	/* Sets positionRow of object Position to the given argument */
	public void setRow(int newRow) {
		this.positionRow = newRow;
	}
	
	/* Sets positionColumn of object Position to the given argument */
	public void setCol(int newColumn) {
		this.positionColumn = newColumn;
	}
	
	/** Boolean methods */
	
	/* Returns true if the class object's instance variables are equal to those of the Position
	 * object given in the argument */
	public boolean equals(Position otherPosition) {
		if (this.positionRow == otherPosition.getRow() && this.positionColumn == otherPosition.getCol()) {
			return true;
		}
		else {
			return false;
		}
	}
}


