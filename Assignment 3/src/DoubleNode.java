/**
 *  @author Ryan Xu
 *	CS1027
 *  This class represents the nodes in a doubly linked list
 */

public class DoubleNode<T> {
	
	/** Instance Variables */
	private DoubleNode<T> next;
	private DoubleNode<T> prev;
	private T data;
	
	/** Constructor
	 * Sets all instance variables to null */
	public DoubleNode() {
		next = null;
		prev = null;
		data = null;
	}
	
	/** Constructor
	 * Sets all instance variables except data to null
	 * 
	 * @param newData Sets instance variable data */
	public DoubleNode(T newData) {
		next = null;
		prev = null;
		data = newData;
	}
	
	/** Getter Methods */
	
	public DoubleNode<T> getNext() {
		return next;
	}
	
	public DoubleNode<T> getPrev() {
		return prev;
	}
	
	public T getData() {
		return data;
	}
	
	/** Setter Methods */
	
	public void setNext(DoubleNode<T> nextNode) {
		next = nextNode;
	}
	
	public void setPrev (DoubleNode<T> prevNode) {
		prev = prevNode;
	}
	
	public void setData(T newData) {
		data = newData;
	}
}
