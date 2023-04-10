/*******************************************************************************
 * Copyright (c) 2022.
 ******************************************************************************/

import java.io.*;
import java.util.Scanner;

/**
 * This class manages all functions relate to the product
 */
public class OperationToProduct {

    /**
     * Creating and returning a product with info input from keyboard.
     * @return The product
     */
    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        Product product = new Product();
        printLog("Input new ID: ");
        product.setBcode(printInput(sc.nextLine()));
        printLog("Input Product's Name: ");
        product.setTitle(printInput(sc.nextLine()));
        printLog("Input Product's quantity: ");
        product.setQuantity(Integer.parseInt(printInput(sc.nextLine())));
        printLog("Input Product's price: ");
        product.setPrice(Double.parseDouble(printInput(sc.nextLine())));
//        sc.close();
        return product;
    }

    /**
     * Reading all products from the file and insert them to the list at tail.
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyList<Product> list) {
        list.clear();
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNext()) {
                String[] s = sc.nextLine().split("\\|");

                Product product = new Product();
                product.setBcode(s[0].trim());
                product.setTitle(s[1].trim());
                product.setQuantity(Integer.parseInt(s[2].trim()));
                product.setPrice(Double.parseDouble(s[3].trim()));

                list.addTail(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Reading all products from the file and insert them to the stack.
     * @param fileName The file name of the file
     * @param stack     The Stack contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        stack.clear();
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNext()) {
                String[] s = sc.nextLine().split("\\|");

                Product product = new Product();
                product.setBcode(s[0].trim());
                product.setTitle(s[1].trim());
                product.setQuantity(Integer.parseInt(s[2].trim()));
                product.setPrice(Double.parseDouble(s[3].trim()));

                stack.push(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reading all products from the file and insert them to the queue.
     * @param fileName The file name of the file
     * @param queue     The Queue contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
        queue.clear();
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNext()) {
                String[] s = sc.nextLine().split("\\|");

                Product product = new Product();
                product.setBcode(s[0].trim());
                product.setTitle(s[1].trim());
                product.setQuantity(Integer.parseInt(s[2].trim()));
                product.setPrice(Double.parseDouble(s[3].trim()));

                queue.enqueue(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adding a product to the list, info of the product input from keyboard.
     * @param list The Linked list
     */
    public void addLast(MyList<Product> list) {
        Product product = createProduct();
        list.addTail(product);
        printLog("\nSuccessfully!\n");
    }

    /**
     * Printing all prodcuts of the list to console screen
     * @param list
     */
    public void displayAll(MyList<Product> list){
        printLog(String.format("%-10s|%-20s|%10s|%10s%n", "ID", "Title", "Quantity", "Price"));
        printLog(list.toString());
        printLog("\nSuccessfully!\n");
    }

    /**
     * Printing all prodcuts of the list to console screen
     * @param stack
     */
    public void displayAll(MyStack<Product> stack){
        printLog(String.format("%-10s|%-20s|%10s|%10s%n", "ID", "Title", "Quantity", "Price"));
        printLog(stack.toString());
        printLog("\nSuccessfully!\n");
    }

    /**
     * Printing all prodcuts of the list to console screen
     * @param queue
     */
    public void displayAll(MyQueue<Product> queue){
        printLog(String.format("%-10s|%-20s|%10s|%10s%n", "ID", "Title", "Quantity", "Price"));
        printLog(queue.toString());
        printLog("\nSuccessfully!\n");
    }

    /**
     * Writing all products from the list to the file
     * @param fileName Input file name
     * @param list     Input Linked list
     */
    public void writeAllItemsToFile(String fileName, MyList<Product> list) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName, false)));
            Node<Product> curr = list.getHead();

            while (curr != null) {
                pw.printf("%-10s|%-20s|%10d|%10.2f%n",
                        curr.info.getBcode(),
                        curr.info.getTitle(),
                        curr.info.getQuantity(),
                        curr.info.getPrice());
                curr = curr.next;
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printLog("\nSuccessfully!\n");
        }
    }

    /**
     * Searching product by ID input from keyboard.
     * @param list
     */
    public Product searchByCode(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        printLog("Input ID to search = ");
        String bcode = printInput(sc.nextLine());
        Product p = new Product(bcode);
        Node<Product> x = list.getHead();
        while (x != null) {
            if (p.equals(x.info)) {
                printLog("Result: " + x.info);
                return x.info;
            }
            x = x.next;
        }
        printLog("-1");
        return null;
    }

    /**
     * Deleting first product that has the ID input from keyboard from the list.
     * @param list
     */
    public void deleteByCode(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        printLog("Input the bcode to delete = ");
        String bcode = printInput(sc.nextLine());
        Product p = new Product(bcode);
        Node<Product> x = list.getHead();
        while (x != null) {
            if (p.equals(x.info)) {
                list.remove(x.info);
                printLog("\nDeleted!\n");
            }
            x = x.next;
        }
    }

    /**
     * Sorting products in linked list by ID
     * @param list The Linked list
     */
    public void sortByCode(MyList<Product> list) {
        list.quickSort();
//        list.bubbleSort();
        printLog("\nSuccessfully!\n");
    }

    /**
     * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010
     * @param i Input decimal number
     * @return a integer numbers
     */
    public long convertToBinary(int i) {
        if (i==0) return 0;
        return i % 2 + 10 * convertToBinary(i/2);
    }

    public void listSample(MyList<Product> list) {
        list.clear();
        list.addTail(new Product("123" , "Golden dsDildo", 201, 202));
        list.addHead(new Product("121" , "Golden Dildo", 200, 100));
        list.addTail(new Product("125" , "Golden fsdDildo", 202, 303));
        list.addTail(new Product("121" , "Golden dsfDildo", 203, 404));
        list.addTail(new Product("129" , "Golden Difsdfldo", 304, 505));
        list.addTail(new Product("" , "Golden Difsdfldo", 3011, 512));

    }

    /** showMenu method */
    public void showMenu() {
        printLog("\n------------------MENU--------------------");
        printLog("\n1. Load data from file and display.");
        printLog("\n2. Input & add to the end.");
        printLog("\n3. Display data.");
        printLog("\n4. Save product list to file.");
        printLog("\n5. Search by ID");
        printLog("\n6. Delete by ID");
        printLog("\n7. Sort by ID.");
        printLog("\n8. Convert to Binary.");
        printLog("\n9. Load to stack and display.");
        printLog("\n10. Load to queue and display.");
        printLog("\n11. DataSample.");
        printLog("\n0. Exit.");
        printLog("\nYou choose: ");
    }

    public void printLog(String s){
        String fileOut = "./ConsoleOutput.txt";
        System.out.print(s);

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileOut, true)));
            pw.print(s);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String printInput(String s) {
        String fileOut = "./ConsoleOutput.txt";
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter( fileOut, true)));
            pw.print(s + "\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

}


