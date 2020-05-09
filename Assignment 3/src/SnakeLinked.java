/**
 *  @author Ryan Xu
 *	CS1027
 *  This class stores information about the snake as it moves around the board
 */

public class SnakeLinked {

	/** Instances Variables */
	int snakeLength;
	DoubleList<Position> snakeBody;
	
	/** Constructor */
	public SnakeLinked(int row, int col) {
		snakeLength = 1;
		snakeBody = new DoubleList();
		Position head = new Position(row, col);
		snakeBody.addData(0, head);
	}
	
	/** Getter Methods*/
	
	public int getLength() {
		return snakeLength;
	}
	
	/** Returns the position object stored in the node of the doubly linked list with the given index 
	 * 
	 * @param The index of the node to return
	 * @return The position of the node of the doubly linked list with the given index */
	public Position getPosition (int index) {
		if (index < 0 || index >= snakeLength) {
			return null;
		}
		else {
			return snakeBody.getData(index);
		}
	}
	
	/** Boolean Method returns true if pos is in the doubly linked list of snakeBody, and returns false otherwise
	 * 
	 * @param pos The Position object to test for equality with Position objects in snakeBody
	 * @return Whether Position pos is in snakeBody
	 */
	public boolean snakePosition(Position pos) {
		boolean found = false;
		int index = 0;
		
		while (found == false && index < snakeLength) {	
			if (pos.equals((Position) snakeBody.getData(index))) {
				found = true;
				}
			index++;
		}
		return found;	
	}
	
	/** Returns the new position of the head of the snake if the snake moved
	 * 
	 * @param direction The specified direction of the movement of the snake
	 * @return The new head position given the movement direction of the snake */
	public Position newHeadPosition(String direction) {
		int row = (int) snakeBody.getNode(0).getData().getRow();
		int column = (int) snakeBody.getNode(0).getData().getCol();
		Position newHeadPosition = new Position(0,0);
		
		if (direction == "up") {
			newHeadPosition.setRow(row - 1);
			newHeadPosition.setCol(column);
		}
		if (direction == "down") {
			newHeadPosition.setRow(row + 1);
			newHeadPosition.setCol(column);
		}
		if (direction == "left") {
			newHeadPosition.setRow(row);
			newHeadPosition.setCol(column - 1);
		}
		if (direction == "right") {
			newHeadPosition.setRow(row);
			newHeadPosition.setCol(column + 1);
		}
		return newHeadPosition;
	}
	
	/** Moves the snake in the specified position
	 * 
	 * @param direction The specified direction of the movement of the snake */
	public void moveSnakeLinked(String direction) {
		snakeBody.addData(0, newHeadPosition(direction));
		snakeBody.removeData(snakeLength);
	}
	
	/** Decreases the value of snakeLength by 1 and deletes the last node in the doubly linked list of snakeBody */
	public void shrink() {
		snakeBody.removeData(snakeLength - 1);
		snakeLength--;
	}
	
	void grow(String direction) {
		snakeBody.addData(0, newHeadPosition(direction));
		snakeLength++;
	}
}
