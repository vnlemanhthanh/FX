/**
 * Generic version of the Node class.
 * @param <T> the type of the value
 */
public class Node<T> {

    T info;
    Node<T> next;

    /**
     * Default constructor
     */
    private Node() {

    }

    /**
     * Constructor with info and next node
     * @param info The info of this node
     * @param next The next Node of this node
     */
    public Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

    public Node(T info) {
        this(info,null);
    }

    /**
     * Overriding to convert this node to String
     */
    @Override
    public String toString() {
        return this.info.toString();
    }
}


