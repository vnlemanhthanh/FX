package lab4;

public class Main {
    public static void main(String[] args) {
        MyList myList = new MyList();

        myList.addTail(new Person("LAN", 12));
        myList.addHead(new Person("HOA", 21));
        myList.addTail(new Person("MAI", 18));
        myList.addTail(new Person("TRUC", 16));
        myList.traverse();
        myList.clear();

        String[] a = {"HOA","HA","LAN","NOI","MUA","NAY"};
        int[] b = {25,17,26,19,23,21};
        myList.addMany(a,b);

        System.out.println("Traverse:");
        myList.traverse();

        System.out.println("Sort by name:");
        myList.sortByName();
        myList.traverse();
    }
}
