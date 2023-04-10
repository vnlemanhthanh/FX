import java.io.*;
import java.util.*;

public class Main {

    /**
     * Main method
     */
    public static void main(String[] args) throws IOException {
        OperationToProduct operation = new OperationToProduct();
        operation.printLog("\n" + new Date() + "\n");

        Scanner sc = new Scanner(System.in);
        MyList<Product> list = new MyList<>();
        String fileName = "Data.txt";

        while (true) {
            operation.showMenu();
            int choose = Integer.parseInt(operation.printInput(sc.nextLine()));

            if (choose == 0) { //"0. Exit"
                operation.printLog("Good bye. Have a nice day!");
                break;
            }

            switch (choose) {
                case 1: //"1. Load data from file and display"
                    operation.getAllItemsFromFile(fileName, list);
                    operation.displayAll(list);
                    break;
                case 2: //"2. Input & add to the end."
                    operation.addLast(list);
                    break;
                case 3: //"3. Display data"
                    operation.displayAll(list);
                    break;
                case 4: //"4. Save product list to file."
                    operation.writeAllItemsToFile(fileName, list);
                    break;
                case 5: //"5. Search by ID"
                    operation.searchByCode(list);
                    break;
                case 6: //"6. Delete by ID"
                    operation.deleteByCode(list);
                    break;
                case 7: //"7. Sort by ID."
                    operation.sortByCode(list);
                    break;
                case 8: //"8. Convert to Binary"
                    int q = list.getHead().info.getQuantity();
                    long convert = operation.convertToBinary(q);
                    operation.printLog("Quantity = " + q + " --> " + convert);
                    break;
                case 9: //"9. Load to stack and display"
                    MyStack<Product> stack = new MyStack<>();
                    operation.getAllItemsFromFile(fileName, stack);
                    operation.displayAll(stack);
                    break;
                case 10: //"10. Load to queue and display."
                    MyQueue<Product> queue = new MyQueue<>();
                    operation.getAllItemsFromFile(fileName, queue);
                    operation.displayAll(queue);
                    break;
                case 11: //"Sample"
                    operation.listSample(list);
                    operation.displayAll(list);
                    break;
                default: //* Invalid, input again
                    break;
            }

        }

    }

}
