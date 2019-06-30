import java.io.PrintStream;
import java.util.NoSuchElementException; 
import java.util.Iterator;

/**
 * Defines the methods for a FIFO queue that handles characters
 */
public class CharQueueImpl<I> implements CharQueue<I> {
	private Node<I> head, tail;
	private int n;
	String name;
	
	public CharQueueImpl(){
		this("CharQueueImpl");
	}
	
	public CharQueueImpl(String name){
		this.name = name;
		head = null;
		tail = null;
		n = 0;
	}
	/**
	 * @return true if the queue is empty
	 */
	public boolean isEmpty(){
		return head == null;
	}

	/**
	 * insert a single character to the queue
	 */
	public void put(I item){
		Node<I> k = tail;
        tail = new Node<I>(item);
        tail.item = item;
        tail.next = null;
        
		if (isEmpty()) 
			head = tail;
        else           
			k.next = tail;
        n++;
	}

	/**
 	 * remove and return the oldest item of the queue
 	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public I get() throws NoSuchElementException{
		if (isEmpty()) 
			throw new NoSuchElementException("Queue underflow");
        I item = head.item;
        head = head.next;
        n--;
        if (isEmpty()) 
			tail = null;   
        return item;
	}

	/**
	 * return without removing the oldest item of the queue
 	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public I peek() throws NoSuchElementException{
		if (isEmpty())
			throw new NoSuchElementException("Queque underflow");
		return head.item;
	}


	/**
	 * print the elements of the queue, starting from the oldest 
         * item, to the print stream given as argument. For example, to 
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

		// while not at end of list, output p node's item
		while (node1 != null) {
			System.out.printf("%s ", node1.item);
			node1 = node1.next;
		} // end while

		System.out.println("\n");
	}

	/**
	 * return the size of the queue, 0 if it is empty
	 * @return number of elements in the queue
	 */
	public int size(){
		return n;
	}
}
