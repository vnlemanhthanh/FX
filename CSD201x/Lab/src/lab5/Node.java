package lab5;

public class Node {
    int info;
    Node nextNode;

    public Node(int info, Node nextNode) {
        this.info = info;
        this.nextNode = nextNode;
    }

    public Node(int info) {
        this(info, null);
    }

}
