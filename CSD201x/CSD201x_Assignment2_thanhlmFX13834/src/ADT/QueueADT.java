package ADT;

public interface QueueADT<T> {
    boolean isEmpty();
    void enqueue(T x);
    T peek();
    T dequeue();
}
