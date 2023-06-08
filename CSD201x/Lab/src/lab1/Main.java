package lab1;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Test input
        int [] b = {5, 7, 11, 3, 9, 2, 6};
        new SimpleSort(b).bubbleSort();

        System.out.println("=====================================");
        System.out.println("Độ dài mảng: ");
        int n  = Integer.parseInt(sc.nextLine());

        int[] a = new int[n];
        // Nhập các phần tử của mảng
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = Integer.parseInt(sc.nextLine());
        }

        /**
         * sắp xếp các phần tử của mảng
         * theo thứ tự tăng dần bằng thuật toán nổi bọt (bubble sort) */
        new SimpleSort(a).bubbleSort();



    }
}
