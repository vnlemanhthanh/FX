package lab5;

public class MyStack implements StackADT {
    private Node head;

    public MyStack() {
    }
    
    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }


    public void push(int x) {
        head = new Node(x, head);
    }

    public int peek() {
        if (head == null) {
            throw new RuntimeException("Stack is Empty");
        }
        return this.head.info;
    }


    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        Node x = head;
        head = head.nextNode;
        return x.info;
    }

    public void convertToBinary(int x) {
        this.clear();
        if (x==0) System.out.println("0");
        while (x != 0) {
            int d = x % 2;
            this.push(d);
            x = x / 2;
        }
        String s = "";
        while (!this.isEmpty()) {
            s += this.pop();
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        int x = 9;
        MyStack stack = new MyStack();
        stack.convertToBinary(x);

        System.out.println(stack.isEmpty());
//        System.out.println(stack.peek());
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.peek());
        stack.push(-1);
        stack.push(-2);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
