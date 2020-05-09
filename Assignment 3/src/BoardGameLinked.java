/**
 *  @author Ryan Xu
 *	CS1027
 *  This class represents the board game where the snake moves around eating apples
 */

public class BoardGameLinked {

	/** Instance Variables */
	private int boardLength;
	private int boardWidth;
	private SnakeLinked theSnake;
	DoubleList<String>[] board;
	
	/** Constructor
	 * Initializes instance variables
	 */
	public BoardGameLinked(String boardFile) {
		MyFileReader file = new MyFileReader(boardFile);
		file.readInt(); //reads 1st line
		file.readInt(); //reads 2nd line
		boardLength = file.readInt(); //reads 3rd line
		boardWidth = file.readInt(); //reads 4th line
		theSnake = new SnakeLinked(file.readInt(), file.readInt()); //reads 5th and 6th line
		board = new DoubleList[boardWidth];
		for (int i = 0; i < boardWidth; i++) {
			DoubleList<String> newDoubleList = new DoubleList();
			board[i] = newDoubleList;
			for (int j = 0; j < boardLength; j++) {
				board[i].addData(j, "empty"); //creates a list of DoublyLinkedLists filled with String Objects == "empty"
			}
		}
		while (file.endOfFile() == false) {
			//places a String object != to "empty" in the matrix
			this.setObject(file.readInt(), file.readInt(), file.readString());
		}
	}
	
	/** Returns the string stored in the DoubleNode stored in the DoubleList referenced by row
	 * and indexed by column
	 * 
	 * @param row References the indexed DoubleList of board to access
	 * @param col References the indexed DoubleNode of DoubleList to access
	 * @return The string stored in the DoubleNode stored in the DoubleList referenced by row and indexed by column
	 * @throws InvalidPositionException If given index is out of bounds */
	public String getObject(int row, int col) {
		if (row < 0 || row >= boardLength || col < 0 || col >= boardLength) {
			throw new InvalidPositionException("The given index is invalid.");
		}
		else {
			return (board[row].getNode(col).getData());
		}
	}
	
	/** Stores the string newObject in the DoubleNode stored in the DoubleList referenced by row
	 * and indexed by column
	 * @param row References the indexed DoubleList of board to access
	 * @param col References the indexed DoubleNode of DoubleList to access
	 * @param newObject The string to be stored in the DoubleNode stored in the DoubleList referenced by row and indexed by column
	 * @throws InvalidPositionException If given index is out of bounds */
	public void setObject(int row, int col, String newObject) throws InvalidPositionException {
		if (row < 0 || row >= boardLength || col < 0 || col >= boardLength) {
			throw new InvalidPositionException("The given index is invalid.");
		}
		else {
			board[row].getNode(col).setData(newObject);;
		}
	}
	
	/** Returns theSnake
	 * @return the Snake */
	public SnakeLinked getSnakeLinked() {
		return this.theSnake;
	}
	
	/** Getter Methods */
	
	public int getLength() {
		return this.boardLength;
	}
	
	public int getWidth() {
		return this.boardWidth;
	}
}
