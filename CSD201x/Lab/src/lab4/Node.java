package lab4;

public class Node {
    private Person info;
    private Node nextNode;

    public Node(Person info) {
        this.info = info;
    }

    public Person getInfo() {
        return info;
    }

    public void setInfo(Person info) {
        this.info = info;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return this.info.toString();
    }
}
