package ADT;

public interface StackADT<T> {
    boolean isEmpty();
    void push(T x);
    T peek();
    T pop();
}
