import java.util.NoSuchElementException;

/**
 * Generic version of the LinkedList class.
 * @param <T> the type of the value
 */
public class MyList<T extends Comparable<T>> {

    /**
     * Head node, default is null
     */
    private Node<T> head;

    /**
     * Tail node, default is null
     */
    private Node<T> tail;

    /**
     * Default constructor
     */
    public MyList() {

    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public Node<T> getHead() {
        Node<T> h = head;
        if (h == null)
            throw new NoSuchElementException();
        return h;
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public Node<T> getTail() {
        Node<T> t = tail;
        if (t == null)
            throw new NoSuchElementException();
        return t;
    }

    /**
     * Checking if this list is empty
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Links e as head element.
     */
    private void linkHead(T e) {
        Node<T> h = head;
        Node<T> newNode = new Node<>(e, h);
        head = newNode;
        if (h == null)
            tail = newNode;
    }

    /**
     * Links e as tail element.
     */
    void linkTail(T e) {
        Node<T> t = tail;
        Node<T> newNode = new Node<>(e);
        tail = newNode;
        if (t == null)
            head = newNode;
        else
            t.next = newNode;
    }

    /**
     * Unlinks non-null head node h.
     */
    private T unlinkHead(Node<T> h) {
        // assert h == head && h != null;
        T element = h.info;
        Node<T> next = h.next;
        h.info = null;
        h.next = null; // help GC
        head = next;
        if (next == null) tail = null;
        return element;
    }

    /**
     * Unlinks non-null node x.
     */
    T unlink(Node<T> x) {
        // assert x != null;
        T element = x.info;
        Node<T> next = x.next;
        if (x != head) {
            Node<T> prev= head;
            while (prev != null && prev.next != x) {
                prev = prev.next;
            }
            if (prev == null) throw new AssertionError();
            prev.next = next;
        } else {
            head = next;
        }
        x.info = null;
        x.next = null;
        return element;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to add
     */
    public void addHead(T e) {
        linkHead(e);
    }

    /**
     * Appends the specified element to the end of this list.
     * @param e the element to add
     */
    public void addTail(T e) {
        linkTail(e);
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public T removeHead() {
        Node<T> h = head;
        if (h == null)
            throw new NoSuchElementException();
        return unlinkHead(h);
    }

    /**
     * Returning the length of this list
     * @return The length of this list
     */
    public int size() {
        if (head == null) {
            return -1;
        }
        int length = 0;
        Node<T> curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    /**
     * Searching and deleting an item from this list by  items
     * @param item The item to be deleted
     */
    public boolean remove(T item) {
        if (item == null) {
            for (Node<T> x = head; x != null; x = x.next) {
                if (x.info == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<T> x = head; x != null; x = x.next) {
                if (item.equals(x.info)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public T get(int index) {
        checkElementIndex(index);
        return node(index).info;
    }

    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size();
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException();
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    Node<T> node(int index) {
        // assert index >= 0 && index < size();
        Node<T> x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    public int indexOf(T item) {
        int index = 0;
        if (item == null) {
            for (Node<T> x = head; x != null; x = x.next) {
                if (x.info == null)
                    return index;
                index++;
            }
        } else {
            for (Node<T> x = head; x != null; x = x.next) {
                if (item.equals(x.info))
                    return index;
                index++;
            }
        }
        return -1;
    }

    /**
     * Insert an item at position to this list
     * @param position The position of new item
     * @param item     The item to be inserted
     */
    public void insertAfterPosition(int position, T item) {
        Node<T> p = node(position);
        if (p == null) return;
        Node<T> pNext = p.next;
        Node<T> insert = new Node<>(item, pNext);
        p.next = insert;
        if (tail == p) {
            tail = insert;
        }
    }

    /**
     * Removes the element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public T remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    /**
     * Swaping two nodes [firstNode] and [secondNode]
     * @param firstNode to swap
     * @param secondNode to swap
     **/
    public void swap(Node<T> firstNode, Node<T> secondNode) {
        T tempInfo = firstNode.info;
        firstNode.info = secondNode.info;
        secondNode.info = tempInfo;
    }

    public void bubbleSort() {
        if (isEmpty()) return;
        Node<T> curr = head, toSwap = null;
        while (curr != null) {
            toSwap = curr.next;
            while (toSwap != null) {
                if (curr.info.compareTo(toSwap.info) > 0) {
                    swap(curr, toSwap);
                }
                toSwap = toSwap.next;
            }
            curr = curr.next;
        }
    }

    public void quickSort() {
        quickSort(head, tail);
    }

    private void quickSort(Node<T> start, Node<T> end) {
        if (start == null || start == end || start == end.next) {
            return;
        }

        // Split list and partition recurse
        Node<T> pivot_prev = paritionLast(start, end);
        quickSort(start, pivot_prev);

        // If pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start) {
            quickSort(pivot_prev.next, end);
        }

            // If pivot is in between of the list,
            // start from next of pivot,
            // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null && pivot_prev.next != null) {
            quickSort(pivot_prev.next.next, end);
        }
    }

    private Node<T> paritionLast(Node<T> start, Node<T> end) {
        if (start == end || start == null || end == null)
            return start;

        Node<T> pivot_prev = start;
        Node<T> curr = start;
        T pivot = end.info;

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (pivot.compareTo(start.info) > 0) {

                // keep tracks of last modified item
                pivot_prev = curr;
                swap(start, curr);
                curr = curr.next;
            }
            start = start.next;
        }

        // Swap the position of curr i.e.
        // next suitable index and pivot
        swap(curr, end);


        // Return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    /**
     * Deleting all items in the list
     */
    public void clear() {
        head = tail = null;
    }

    public void visit(Node<T> p) {
        System.out.format(p + "\n");
    }

    @Override
    public String toString() {
        String result = "";
        Node<T> curr = head;
        while (curr != null) {
            result = result.concat(curr + "\n");
            curr = curr.next;
        }
        return result;
    }

}


