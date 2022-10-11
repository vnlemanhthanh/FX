package main;

import java.util.*;
/** Một chương trình có thể đọc, ghi dữ liệu từ tệp phục vụ cho việc sắp xếp và tìm kiếm dữ liệu */
public class Main {

    static float[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Algorithm algo = new Algorithm();
        String fileName;

        while (true) {
            algo.showMenu();

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 0) { // Thoát While loop khi chọn 0
                System.out.println("Goodbye, have a nice day!");
                break;
            }

            switch (choice) {
                case 1: /* Nhập dữ liệu từ bàn phím: */
                    arr = algo.inputArray();
                    fileName = "./src/resource/input.txt";

                    algo.writeFile(fileName, arr);
                    break;

                case 2: // Đọc dữ liệu từ tệp lưu vào mảng arr và hiển thị dữ liệu ra màn hình
                    System.out.println("Read from file ");

                    fileName = "./src/resource/input.txt";
                    arr = algo.readFile(fileName);

                    System.out.print("Array: ");
                    new Algorithm(arr).display();
                    break;

                case 3: // Sắp xếp theo thuật toán Bubble Sort
                    System.out.println("Bubble Sort ");
                    algo = new Algorithm(arr);

                    algo.bubbleSort(algo.getArray(), true);

                    break;

                case 4: // Sắp xếp theo thuật toán Selection Sort
                    System.out.println("Selection Sort ");
                    algo = new Algorithm(arr);

                    algo.selectionSort(algo.getArray(), true);

                    break;

                case 5: // Sắp xếp theo thuật toán Insertion Sort
                    System.out.println("Insertion Sort ");
                    algo = new Algorithm(arr);

                    algo.insertionSort(algo.getArray(), true);

                    break;

                case 6: // Tìm kiếm theo thuật toán Tìm Kiếm Tuyến Tính (Linear Search)
                    System.out.println("Linear Search ");
                    do {
                        System.out.print("Input value: ");
                        float value = Float.parseFloat(sc.nextLine());

                        algo.search(arr, value);

                        System.out.print(" enter 0 to go to Menu, are you continous? ");
                        choice = Integer.parseInt(sc.nextLine());
                    } while (choice != 0); // Thoát While loop khi chọn 0

                    break;

                case 7: // Tìm kiếm theo thuật toán nhị phân
                    System.out.println("Binary Search ");
                    do {
                        System.out.print("Input value: ");
                        float value = Float.parseFloat(sc.nextLine());

                        algo = new Algorithm(arr);
                        algo.insertionSort(algo.getArray());

                        algo.binarySearch(arr, value);

                        System.out.print(" enter 0 to go to Menu, are you continous? ");
                        choice = Integer.parseInt(sc.nextLine());
                    } while (choice != 0); // Thoát While loop khi chọn 0

                    break;

                case 8: // Comparision
                    System.out.println("Compare Sort ");
                    
                    do {
                        compareSort(sc); // độ dài mảng tự nhập

                        System.out.print(" enter 0 to go to Menu, are you continous? ");
                        choice = Integer.parseInt(sc.nextLine());
                    } while (choice != 0); // Thoát While loop khi chọn 0

                    break;
                case 9: // Comparision Sample
                    System.out.println("Compare Sort Sample");
                    compareSort(1);

                    break;

                default:
                    System.out.println("**Invalid choice. Try again.**");
            }
        }
    }

    /** In ra bảng thời gian chạy của 3 thuật toán sắp xếp,
     * Theo từng kiểu dữ liệu: đã sắp xếp, sắp xếp ngược, xáo trộn ngẫu nhiên */
    public static void compareSort(Scanner sc) {
        System.out.print(" Input first array length = ");
        int length = Integer.parseInt(sc.nextLine());

        compareSort(length);
    }

    /** In ra bảng thời gian chạy của 3 thuật toán sắp xếp,
     * Theo từng kiểu dữ liệu: sắp xếp ngược, xáo trộn ngẫu nhiên, đã sắp xếp */
    public static void compareSort(int length) {

        System.out.format("+%-60s+%n", "-----------Reverse Array-----------");
        System.out.format("|%-12s|%-15s|%-15s|%-15s|%n", "Arr.Length",  "Bubble Sort", "Selection Sort", "Insertion Sort" );
        timeSort(Algorithm.reverseArray(length));
        timeSort(Algorithm.reverseArray(3 * length));
        timeSort(Algorithm.reverseArray(10 * length));
        timeSort(Algorithm.reverseArray(30 * length));
        timeSort(Algorithm.reverseArray(100 * length));
        timeSort(Algorithm.reverseArray(300 * length));
        if (length < 100) timeSort(Algorithm.reverseArray(1000 * length));
        if (length < 30) timeSort(Algorithm.reverseArray(3000 * length));
        if (length < 10) timeSort(Algorithm.reverseArray(10000 * length));
        if (length <= 3) timeSort(Algorithm.reverseArray(30000 * length));
        if (length < 3) timeSort(Algorithm.reverseArray(100000 * length));

        System.out.format("+%-60s+%n", "----------Original Array----------");
        System.out.format("|%-12s|%-15s|%-15s|%-15s|%n", "Arr.Length",  "Bubble Sort", "Selection Sort", "Insertion Sort" );
        timeSort(Algorithm.originalArray(length));
        timeSort(Algorithm.originalArray(3 * length));
        timeSort(Algorithm.originalArray(10 * length));
        timeSort(Algorithm.originalArray(30 * length));
        timeSort(Algorithm.originalArray(100 * length));
        timeSort(Algorithm.originalArray(300 * length));
        if (length < 100) timeSort(Algorithm.originalArray(1000 * length));
        if (length < 30) timeSort(Algorithm.originalArray(3000 * length));
        if (length < 10) timeSort(Algorithm.originalArray(10000 * length));
        if (length <= 3) timeSort(Algorithm.originalArray(30000 * length));
        if (length < 3) timeSort(Algorithm.originalArray(100000 * length));

        System.out.format("+%-60s+%n", "----------Sorted Array----------");
        System.out.format("|%-12s|%-15s|%-15s|%-15s|%n", "Arr.Length",  "Bubble Sort", "Selection Sort", "Insertion Sort" );
        timeSort(Algorithm.sortedArray(length));
        timeSort(Algorithm.sortedArray(3 * length));
        timeSort(Algorithm.sortedArray(10 * length));
        timeSort(Algorithm.sortedArray(30 * length));
        timeSort(Algorithm.sortedArray(100 * length));
        timeSort(Algorithm.sortedArray(300 * length));
        if (length < 100) timeSort(Algorithm.sortedArray(1000 * length));
        if (length < 30) timeSort(Algorithm.sortedArray(3000 * length));
        if (length < 10) timeSort(Algorithm.sortedArray(10000 * length));
        if (length <= 3) timeSort(Algorithm.sortedArray(30000 * length));
        if (length < 3) timeSort(Algorithm.sortedArray(100000 * length));

    }

    /** In ra bảng thời gian chạy 3 thuật toán theo mảng dữ liệu đầu vào */
    public static void timeSort(float[] arr) {
        Algorithm algo;
        System.out.printf("|%12s|", arr.length);

        // Time of bubbleSort
        algo = new Algorithm(arr);
        long startBubble, timeBubble;
        startBubble = System.nanoTime();
        algo.bubbleSort(algo.getArray());
        timeBubble = System.nanoTime() - startBubble;
        System.out.printf("%15s|", timeBubble/100);

        // Time of SelectionSort
        algo = new Algorithm(arr);
        long startSelection, timeSelection;
        startSelection = System.nanoTime();
        algo.selectionSort(algo.getArray());
        timeSelection = System.nanoTime()- startSelection;
        System.out.printf("%15s|", timeSelection/100);

        // Time of InsertionSort
        algo = new Algorithm(arr);
        long startInsertion, timeInsertion;
        startInsertion = System.nanoTime();
        algo.insertionSort(algo.getArray());
        timeInsertion = System.nanoTime() - startInsertion;
        System.out.format("%15s|%n", timeInsertion/100);

    }

}
