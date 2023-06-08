package lab3;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addTail(2);
        list.addHead(1);
        list.addTail(3);
        list.addTail(4);
        list.addTail(5);
        list.addTail(6);

        list.traverse();
        list.clear();

        int[] a = {7,2,9,8,6,3};
        list.addMany(a);

        System.out.print("\nTraverse:");
        list.traverse();

        System.out.print("\nSearch(8): ");
        System.out.print(list.search(8));

    }
}
