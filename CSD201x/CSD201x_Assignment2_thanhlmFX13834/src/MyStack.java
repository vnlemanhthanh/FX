import ADT.StackADT;

import java.util.NoSuchElementException;

/**
 * Generic version of the Stack class.
 * @param <T> the type of the value
 */
class MyStack<T> implements StackADT<T> {

    /**
     * Top node contains head node in the stack
     */
    Node<T> top;

    public MyStack() {
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
    }

    @Override
    public void push(T x) {
        top = new Node<>(x, top);
    }

    @Override
    public T peek() {
        if (top == null)
            throw new RuntimeException("Stack is Empty");
        return top.info;
    }

    @Override
    public T pop() {
        if (top == null)
            throw new RuntimeException("Stack is Empty");
        Node<T> x = top;
        top = top.next;
        return x.info;
    }

    @Override
    public String toString() {
//        if (top == null) return null;
        String result = "";
        Node<T> curr = top;
        while (curr != null) {
            result += curr + "\n";
            curr = curr.next;
        }
        return result;
    }

}