package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> newNode = new LLNode<E>(element, tail, null);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> curNode = head;
		int curIndex = 0;
		while (curIndex < index) {
			curNode = curNode.next;
			curIndex++;
		}
		return curNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			LLNode<E> newNode = new LLNode<>(element, null, head);
			if (head != null) head.prev = newNode;
			head = newNode;
			size++;
			if (size == 1) {
				tail = newNode;
			}
			return;
		}
		if (size == index) {
			LLNode<E> newNode = new LLNode<>(element, tail, null);
			tail = tail.next;
			size++;
			return;
		}
		LLNode<E> curNode = head;
		int curIndex = 0;
		while (curIndex < index - 1) {
			curNode = curNode.next;
			curIndex++;
		}
		LLNode<E> nextNode = curNode.next;
		LLNode<E> newNode = new LLNode<>(element, curNode, nextNode);
		if (size > 0) {
			curNode.next = newNode;
		}
		if (nextNode != null) {
			nextNode.prev = newNode;
		}
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> curNode = head;
		int curIndex = 0;
		while (curIndex < index) {
			curNode = curNode.next;
			curIndex++;
		}
		if (head == curNode) {
			head = head.next;
		}
		if (tail == curNode) {
			tail = tail.prev;
		}
		if (curNode.prev != null) {
			curNode.prev.next = curNode.next;
		}
		if (curNode.next != null) {
			curNode.next.prev = curNode.prev;
		}
		curNode.prev = null;
		curNode.next = null;
		size--;
		return curNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> curNode = head;
		int curIndex = 0;
		while (curIndex < index) {
			curNode = curNode.next;
			curIndex++;
		}
		curNode.data = element;
		return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e, LLNode<E> prev, LLNode<E> next) 
	{
		this.data = e;
		this.prev = prev;
		this.next = next;
	}
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
