package lab5;

import java.util.EmptyStackException;

public interface StackADT {
    boolean isEmpty();
    void push(int x);
    int peek() throws EmptyStackException;
    int pop();
}
