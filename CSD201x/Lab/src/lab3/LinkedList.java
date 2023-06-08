package lab3;

public class LinkedList {
    Node head, tail;

    public LinkedList() {
        head = tail = null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public void addHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.setNextNode(head);
        head = newNode;
    }

    public void addTail(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.tail = this.head =  newNode;
        }
        this.tail.setNextNode(newNode);
        this.tail = newNode;
    }

    public void traverse() {
        System.out.print(this);
    }

    public void addMany(int[] a) {
        for (int e : a) {
            this.addTail(e);
        }
    }

    public int search(int i) {
        int index = 0;
        Node curr = this.head;
        while (curr != null) {
            index++;
            if (curr.getData() > i) {
                return index;
            }
            curr = curr.getNextNode();
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node curr = this.head;
        while (curr != null) {
            result.append(curr).append(" ");
            curr = curr.getNextNode();
        }
        return result.toString();
    }

}
