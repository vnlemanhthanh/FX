package lab2;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Độ dài mảng: ");
        int n  = Integer.parseInt(sc.nextLine());

        int[] a = new int[n];
        // Nhập các phần tử của mảng
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = Integer.parseInt(sc.nextLine());
        }

        while (true) {
            System.out.println("\n Choose your option: ");
            System.out.println(" 1. Display data");
            System.out.println(" 2. Selection sort");
            System.out.println(" 3. Insertion sort");
            System.out.println(" 4. Search");
            System.out.println(" 0. Exit\n");
            System.out.println(" Your selection (0 -> 4):");
            int choose = Integer.parseInt(sc.nextLine());

            if (choose == 0) { // Exit
                System.out.println(" Good bye, have a nice day!");
                break;
            }

            switch (choose) {
                case 1:
                    System.out.println("=====================================");
                    new SimpleSort(a).display();
                    break;
                case 2:
                    System.out.println("=====================================");
                    new SimpleSort(a).selectSort();
                    break;
                case 3:
                    System.out.println("=====================================");
                    new SimpleSort(a).insertSort();
                    break;
                case 4:
                    System.out.println("=====================================");
                    System.out.println("value: ");
                    int index =  new SimpleSort(a).search(Integer.parseInt(sc.nextLine()));
                    System.out.println("index: "+ index);
                    break;
                default:
                    System.out.println("**Invalid choice. Try again.**");
                    break;
            }
        }
    }
}
