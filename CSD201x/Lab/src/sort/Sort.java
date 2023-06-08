/*******************************************************************************
 * Copyright (c) 2022.
 ******************************************************************************/

package sort;

public class Sort {

    private Sort() { }

    @SuppressWarnings("rawtypes")
    public static Comparable[] sort(Comparable[] a) {
//        bubbleSort(a);
//        selectionSort(a);
        insertionSort(a);
        return a;
    }

    public static void bubbleSort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n -1; i++) {
            for (int j = 0; j < n - 1 - i ; j++) {
                if (less(a[j+1], a[j] )) {
                    swap(a, j, j+1);
                }
            }
            show(a);
        }
    }

    public static void selectionSort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
            //show(a);
        }
    }

    public static void insertionSort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i ++) {
            for (int j = i; j > 0 && less(a[j], a[j-1] ) ; j--) {
                swap(a, j, j-1);
            }
            show(a);
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] a) {
        for (Comparable e : a) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    //Test Client
    public static void main(String[] args) {
        Integer[] a = {9, 4, 3, 6, 2, 2, 4};
        Sort.show(sort(a.clone()));
    }
}
