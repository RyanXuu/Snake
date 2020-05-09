/**
 *  @author Ryan Xu
 *	CS1027
 *  This class represents a doubly linked list of nodes of the class DoubleNode
 */

public class DoubleList<T> {
	
	/** Instance Variables */
	private DoubleNode<T> head;
	private DoubleNode<T> rear;
	private int numDataItems;
	
	/** Constructor
	 * Initializes instance variables
	 */
	public DoubleList() {
		head = null;
		rear = null;
		numDataItems = 0;
	}
	
	/** Adds a new node the list storing newData
	 * 
	 * @param index Determines where to insert newData
	 * @param newData Determines data contained within the node at index position
	 * @throws InvalidPositionException If given index is out of bounds */
	public void addData(int index, T newData) throws InvalidPositionException {
		
		DoubleNode<T> node = new DoubleNode(newData);
		
		if (index < 0 || index > numDataItems) {
			throw new InvalidPositionException("The given index is invalid.");
		}
		if (numDataItems == 0) {
			head = node;
			rear = node;
			numDataItems++;
		}
		else {
			if (index == 0) {
				DoubleNode<T >current = this.getNode(0);
				node.setNext(current);
				current.setPrev(node);
				head = node;
				numDataItems++;
			}
			else if (index == numDataItems) {
				DoubleNode<T> current = this.getNode(numDataItems - 1);
				current.setNext(node);
				node.setPrev(current);
				rear = node;
				numDataItems++;
			}
			else {
				DoubleNode<T> prevNode = this.getNode(index - 1);
				DoubleNode<T> nextNode = this.getNode(index);
				node.setPrev(prevNode);
				node.setNext(nextNode);
				prevNode.setNext(node);
				nextNode.setPrev(node);
				numDataItems++;
			}
		}
	}
	
	/** Returns the node that is at the index position of the list
	 * 
	 * @param index Determines what index node to return
	 * @return Node at given index
	 * @throws InvalidPositionException If given index is out of bounds */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException {
		if (index < 0 || index > numDataItems) {
			throw new InvalidPositionException("The given index is invalid.");
		}
		else if (index == 0) {
			return head;
		}
		else if (index == numDataItems - 1) {
			return rear;
		}
		else {
			DoubleNode<T> interiorNode = head;
			for (int i = 0; i < index; i++) {
				interiorNode = interiorNode.getNext();
			}
			return interiorNode;
		}
	}
	
	/** Removes the node that is at the index position of the list
	 * 
	 * @param index Determines what index node to remove
	 * @throws InvalidPositionException If given index is out of bounds */
	public void removeData(int index) throws InvalidPositionException {
		
		if (index < 0 || index > numDataItems) {
			throw new InvalidPositionException("The given index is invalid.");
		}
		
		if (numDataItems == 1) {
			head = null;
			rear = null;
			numDataItems = 0;
		}
		else {
			if (index == 0) {
				DoubleNode<T> newHead = this.getNode(1);
				newHead.setPrev(null);
				head = newHead;
				numDataItems--;
			}
			else if (index == numDataItems - 1) {
				DoubleNode<T> newRear = this.getNode(numDataItems - 2);
				newRear.setNext(null);
				rear = newRear;
				numDataItems--;
			}
			else {
				DoubleNode<T> interiorNode = head;
				for (int i = 0; i < index; i++) {
					interiorNode = interiorNode.getNext();
				}
				DoubleNode<T> prevNode = interiorNode.getPrev();
				DoubleNode<T> nextNode = interiorNode.getNext();
				prevNode.setNext(nextNode);
				nextNode.setPrev(prevNode);
				numDataItems--;
			}
		}
	}
	
	/** Returns the data stored at in the node located at the index position of the list
	 * 
	 * @param index Determines what index position to retrieve data from
	 * @return data from node at given index position */
	public T getData(int index) {
		if (index < 0 || index > numDataItems) {
			throw new InvalidPositionException("The given index is invalid.");
		}
		else {
			return this.getNode(index).getData();
		}
	}
	
	/** Stores newData in the node at index position of the list
	 * 
	 * @param index Determines what index position to store data
	 * @param newData Determines what data to store in node at index position
	 * @throws InvalidPositionException If given index is out of bounds */
	public void setData(int index, T newData) throws InvalidPositionException {
		if (index < 0 || index > numDataItems) {
			throw new InvalidPositionException("The given index is invalid.");
		}
		else {
			this.getNode(index).setData(newData);
		}
	}
			
}