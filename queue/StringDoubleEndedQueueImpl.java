

import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 * Implements the methods for a Double-ended Queue that handles String items
 */

public class StringDoubleEndedQueueImpl<I> implements StringDoubleEndedQueue<I>{

    private Node<I> head, tail;
    private int size;
    String name;

    public StringDoubleEndedQueueImpl(){
        this("StringDoubleEndedQueueImpl");
    }

    public StringDoubleEndedQueueImpl(String name){
        this.name = name;
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @return true if the queue is empty
     */

    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * insert a String item at the front of the queue
     */
    public void addFirst(I item){
        if ( item == null)
            throw new NoSuchElementException("No item");
        // insert from head, prev = null, next points to existing head.
        Node<I> node = new Node<>(item, head, null);
        if(head == null && tail == null){
            head = node;
            tail = node;
        }
        else if(head == null){
            head = node;
        }
        else if(tail == null){
            head.prev = node;
            head = node;
            tail = node;
        }
        else{
            head.prev = node;
            head = node;
        }
        size++;
    }

    /**
     * remove and return the item at the front of the queue
     * @return String from the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public I removeFirst() throws NoSuchElementException{
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        Node<I> node = head;
        head = head.next;
        head.prev = null;
        size--;
        return node.item;
    }

    /**
     * insert a String item at the end of the queue
     */
    public void addLast(I item){
        if ( item == null)
            throw new NoSuchElementException("No item");
        // insert item from tail, next = null, next points to existing tail.
        Node<I> node = new Node<>(item, null, tail);
        if(head == null && tail == null){
            tail = node;
            head = node;
        }
        else if (head == null ){
            head = node;
            tail.next = node;
            tail = node;
        }
        else if(tail == null){
            tail = node;
        }
        else{
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * remove and return the item at the end of the queue
     * @return String from the end of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public I removeLast() throws NoSuchElementException{
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        Node<I> node = tail;
        if (size == 1){
            tail = null;
            head = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return node.item;
    }

    /**
     * return without removing the item at the front of the queue
     * @return String from the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public I getFirst(){
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return head.item;
    }

    /**
     * return without removing the item at the end of the queue
     * @return String from the end of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public I getLast(){
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return tail.item;
    }


    /**
     * print the String items of the queue, starting from the front,
     * to the print stream given as argument. For example, to
     * print the elements to the
     * standard output, pass System.out as parameter. E.g.,
     * printQueue(System.out);
     */
    public void printQueue(PrintStream stream){
        if (isEmpty()) {
            System.out.printf("Empty %s\n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        Node<I> node = head;
        // while not at end of list, output node1 node's item
        while (node != null) {
            System.out.printf("%s ", node.item);
            node = node.next;
        }

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
