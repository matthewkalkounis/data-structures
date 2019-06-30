import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * Defines the methods for a Double-ended Queue that handles characters
 */

public class CharDoubleEndedQueueImpl<I> implements CharDoubleEndedQueue<I>{
	private Node<I> head, tail;
	private int size;
	String name;
	/**
	 * @return true if the queue is empty
	 */
	public CharDoubleEndedQueueImpl(){
		this("CharDoubleEndedQueueImpl");
	}
	
	public CharDoubleEndedQueueImpl(String name){
		this.name = name;
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}

	/**
	 * insert a character at the front of the queue
	 */
	public void addFirst(I item){
		if ( item == null)
			throw new NoSuchElementException("No item");
		Node<I> node1 = new Node<I>(item, head, null); //because we insert item from head, it has no prev.So prev is null.With the new node1, next points to existing head. 
		if(head == null && tail == null){
			head = node1;
			tail = node1;
		}
		else if( head == null && tail != null){
			head = node1;
		}
		else if(head != null && tail == null){
			head.prev = node1;
			head = node1;
			tail = node1;
		}
		else{
			head.prev = node1;
			head = node1;
		}
		size++;
	}

	/**
	 * remove and return a character from the front of the queue
	 * @return character from the front of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public I removeFirst() throws NoSuchElementException{
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		Node<I> node1 = head;
		head = head.next;
		head.prev = null;
		size--;
		return node1.item;
	}

	/**
	 * insert a character at the end of the queue
	 */
	public void addLast(I item){
		if ( item == null)
			throw new NoSuchElementException("No item");
		Node<I> node1 = new Node<I>(item, null, tail); // because we insert item from tail, it hasn't next to point to. So next is null.With the new node next points to existing tail.
		if(head == null && tail == null){
			tail = node1;
			head = node1;
		}
		else if( head == null && tail != null){
			head = node1;
			tail.next = node1;
			tail = node1;
		}
		else if(head != null && tail == null){
			tail = node1;
		}
		else{
			tail.next = node1;
			tail = node1;
		}		
		size++;
	}

	/**
	 * remove and return a character from the end of the queue
	 * @return character from the end of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public I removeLast() throws NoSuchElementException{
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		Node<I> node1 = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		return node1.item;
	}
	
	/**
	 * return without removing the first item in the queue
	 * @return character from the front of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public I getFirst(){
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		return head.item;
	}

	/**
	 * return without removing the last item in the queue
	 * @return character from the end of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public I getLast(){
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		return tail.item;
	}
	
	
	/**
	 * print the elements of the queue, starting from the front, 
     	 * to the print stream given as argument. For example, to 
         * print the elements to the
	 * standard output, pass System.out as parameter. E.g.,
	 * printQueue(System.out);
	 */
	public void printQueue(PrintStream stream){
		if (isEmpty()) {
			System.out.printf("Empty %s\n", name);
			return;
		} // end if

		System.out.printf("The %s is: ", name);
		Node<I> node1 = head;
		// while not at end of list, output node1 node's item
		while (node1 != null) {
			System.out.printf("%s ", node1.item);
			node1 = node1.next;
		} // end while

		System.out.println("\n");
	}

	/**
	 * return the size of the queue, 0 if empty
	 * @return number of elements in the queue
	 */
	public int size(){
		return size;
	}
}
