package lab5;

public class ArrayStack implements StackADT {
    private int maxSize;
    private int[] items;
    private int top = -1;

    public ArrayStack(int max) {
        maxSize = max;
        items = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top >= maxSize -1) {
            System.out.println("StackOverFlow");
            return;
        }
        items[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("IndexOutOfBound");
            return 0;
        }
        return items[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        }
        return items[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(11);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        stack.push(5);
        stack.push(4);
        stack.push(5);
        stack.push(4);
        stack.push(5);
        stack.push(4);
        stack.push(5);
        stack.push(4);
        stack.push(5);
        stack.push(4);
        stack.push(5);
        stack.push(4);
        System.out.println(stack.peek());
        stack.push(6);
        stack.push(10);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
