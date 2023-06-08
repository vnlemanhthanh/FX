/*******************************************************************************
 * Copyright (c) 2022.
 ******************************************************************************/

package lab2;

import java.util.Arrays;

public class Sort {
    public static void sort(int[] a) {
//        bubbleSort(a);
//        selectionSort(a);
        insertionSort(a);
    }

    private static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int curr = a[i];
            int j = i;
            while (j > 0 && curr < a[j-1]) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = curr;
            System.out.println(Arrays.toString(a));
        }
    }

    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
            System.out.println(Arrays.toString(a));
        }
    }

    private static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean ok = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (less(a[j+1], a[j])) {
                    swap(a,j,j+1);
                    ok = true;
                }
            }
            if (!ok) break;
            System.out.println(Arrays.toString(a));
        }
    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    // test
    public static void main(String[] args) {
        int[] a = {9, 3, 5, 6, 1, 2, 4};
        sort(a);
    }
}
