public class Node<I> {
    public I item;
    public Node<I> next;
    public Node<I> prev;

    Node(I item){
        this.item = item;
        this.next = null;
    }

    Node(I item, Node<I> next){
        this.item = item;
        this.next = next;
    }

    Node(I item, Node<I> next, Node<I> prev){
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    I getObject(){
        return item;
    }

    Node<I> getNext(){
        return next;
    }

    Node<I> getPrev(){
        return prev;
    }

}
