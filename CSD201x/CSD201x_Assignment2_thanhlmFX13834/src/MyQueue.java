import ADT.QueueADT;

/**
 * Generic version of the Queue class.
 * @param <T> the type of the value
 */
class MyQueue<T> implements QueueADT<T> {

    /**
     * Head node contains front node in the queue
     */
    Node<T> front;

    /**
     * Tail node contains last node in the queue
     */
    Node<T> rear;

    public MyQueue() {
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    public void clear() {
        front = rear = null;
    }

    @Override
    public void enqueue(T x) {
        if (front == null) {
            front = rear = new Node<>(x);
            return;
        }
        rear.next = new Node<>(x);
        rear = rear.next;
    }

    @Override
    public T peek() {
        if (front == null) return null;
        return front.info;
    }

    @Override
    public T dequeue() {
        if (front == null) return null;
        Node<T> x = front;
        front = front.next;
        return x.info;
    }

    @Override
    public String toString() {
//        if (front == null) return null;
        String result = "";
        Node<T> curr = front;
        while (curr != null) {
            result += curr + "\n";
            curr = curr.next;
        }
        return result;
    }
}


