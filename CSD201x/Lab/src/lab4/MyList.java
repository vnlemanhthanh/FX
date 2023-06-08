package lab4;

public class MyList {
    Node head, tail;

    public MyList() {
    }

    public boolean isEmpty() {
        return this.head  == null;
    }

    public void clear() {
        this.head = this.tail = null;
    }

    public void add(Person p) {
        addTail(p);
    }

    public void addHead(Person p) {
        Node newNode = new Node(p);
        if (isEmpty()) {
            this.tail = this.head = newNode;
            return;
        }
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    public void addTail(Person p) {
        Node newNode = new Node(p);
        if (isEmpty()) {
            this.tail = this.head = newNode;
            return;
        }
        this.tail.setNextNode(newNode);
        this.tail = newNode;
    }

    public void addMany(String[] a, int[] b) {
        if (a.length != b.length) return;
        for(int i = 0; i < a.length; i++) {
            this.add(new Person(a[i], b[i]));
        }
    }
    
    public void traverse() {
        Node curr = this.head;
        while (curr != null) {
            System.out.println(curr);
            curr = curr.getNextNode();
        }
    }

    public void sortByName() {
        bubberSortByName();
    }

    private void bubberSortByName() {
        if (isEmpty()) return;
        Node curr = this.head, toSwap = null;
        while (curr != null) {
            toSwap = curr.getNextNode();
            while (toSwap != null) {
                if (curr.getInfo().getName().compareTo(toSwap.getInfo().getName()) > 0) {
                    Person temp = curr.getInfo();
                    curr.setInfo(toSwap.getInfo());
                    toSwap.setInfo(temp);
                }
                toSwap = toSwap.getNextNode();
            }
            curr = curr.getNextNode();
        }
    }
}
