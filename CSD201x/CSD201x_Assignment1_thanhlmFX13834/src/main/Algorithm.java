package main;

import java.io.*;
import java.util.Scanner;

public class Algorithm implements IAlgorithm {
    /** Mảng số thực */
    private float[] array;

    /** Constructor */
    public Algorithm() {
    }

    /** Constructor*/
    public Algorithm(float[] arr) {
        array = new float[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
    }

    /** Getter */
    public float[] getArray() {
        return array;
    }

    /** Nhập dữ liệu mảng từ bàn phím */
    public float[] inputArray() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input number of elements: ");
        int n = Integer.parseInt(sc.nextLine());
        array = new float[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Input element " + (i + 1) + ": ");
            array[i] = Float.parseFloat(sc.nextLine());
        }

        return array;
    }

    /** Hàm chuyển array (of Object) thành String */
    @Override
    public String toString() {
        String result = "";
        for (float e: array) {
            result = result.concat(e + " ");
        }
        return result;
    }

    /** Hàm hiển thị ra màn hình */
    public void display() {
        System.out.println(this);
    }

    /**
     * Đổi chỗ 2 element a[i] và a[j] */
    public void swap(float[] arr, int i, int j) {
//        if (i == j) return;
        float t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * In mảng vào file
     * @param fileName tên file để ghi
     * @param arr      mảng đầu vào
     */
    @Override
    public void writeFile(String fileName, float[] arr) {
        writeFile(fileName, arr, false); // Ghi từ đầu
    }

    /**
     * In mảng vào file
     * @param fileName tên file để ghi
     * @param arr      mảng đầu vào
     * @param isAppend  true là ghi nối tiếp, false là ghi từ đầu
     */
    public void writeFile(String fileName, float[] arr, boolean isAppend) {
        String fileContent = new Algorithm(arr).toString();
        writeFile(fileName, fileContent, isAppend);
    }

    /**
     * In mảng vào file
     * @param fileName tên file để ghi
     * @param fileContent      chuỗi đầu vào
     * @param isAppend  true là ghi nối tiếp, false là ghi từ đầu
     */
    public void writeFile(String fileName, String fileContent, boolean isAppend) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName, isAppend)));

            pw.println(fileContent);
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Đọc file sau đó lưu vào mảng
     * @param fileName tên file được đọc
     * @return trả về mảng được đọc từ file
     */
    @Override
    public float[] readFile(String fileName) {
        String fileContent = "";
        try {
            Scanner sc = new Scanner(new File(fileName));

            while (sc.hasNext()) {
                fileContent = fileContent.concat(sc.next() + ",");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] s = fileContent.split( ",");
        float[] arr = new float[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Float.parseFloat(s[i]);
        }
        return arr;
    }


    /**
     * Sorting the input array arr using Bubble Sort algorithm.
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Bubble Sort algorithm
     */
    @Override
    public float[] bubbleSort(float[] arr) {
        return bubbleSort(arr, false);
    }

    /**
     * Sorting the input array arr using Bubble Sort algorithm.
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Bubble Sort algorithm
     */
    public float[] bubbleSort(float[] arr, boolean hasSave) {
        if (hasSave) {
            writeFile("./src/resource/output1.txt" , arr);
        }

        int len = arr.length;
        for (int i = len - 2 ; i >= 0 ; i--) {
            boolean hasSwap = false;
            for (int j = 0; j <= i ; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);   // Đổi vị trí a[j] và a[j+1]
                    hasSwap = true;
                }
            }
            if (hasSave) {
                new Algorithm(arr).display();
                writeFile("./src/resource/output1.txt" , arr, true);
            }

            if (!hasSwap) break;
        }
        return arr;
    }

    /**
     * Sorting the input array arr using Selection Sort algorithm.
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Selection Sort algorithm
     */
    @Override
    public float[] selectionSort(float[] arr) {
         return selectionSort(arr, false);
    }

    /**
     * Sorting the input array arr using Selection Sort algorithm.
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Selection Sort algorithm
     */
    public float[] selectionSort(float[] arr, boolean hasSave) {
        if (hasSave) {
            writeFile("./src/resource/output2.txt" , arr);
        }

        int len = arr.length;
        for (int i = 0; i < len -1; i++) {
            int minIndex = i;
            boolean toSwap = false;

            for (int j = i + 1; j < len; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                    toSwap = true;
                }
            }

            if (toSwap) {
                swap(arr, i, minIndex);
            }

            if (hasSave) {
                new Algorithm(arr).display();
                writeFile("./src/resource/output2.txt" , arr, true);
            }
        }

        return arr;
    }

    /**
     * Sorting the input array arr using Insertion Sort algorithm.
     * @param arr Input array using for searching
     * @return Returning a sorted array by using the Insertion Sort algorithm
     */
    @Override
    public float[] insertionSort(float[] arr) {
        return insertionSort(arr, false);
    }

    /**
     * Sorting the input array arr using Insertion Sort algorithm.
     * @param arr Input array using for searching
     * @return Returning a sorted array by using the Insertion Sort algorithm
     */
    public float[] insertionSort(float[] arr, boolean hasSave) {
        if (hasSave) {
            writeFile("./src/resource/output3.txt" , arr);
        }

        int len = arr.length;
        for (int i = 1; i < len; i++) { //Ban dau day chi co 1 phan tu a[0]
            float x = arr[i]; //chen a[i] vao day da sx a[0],a[1],...,a[i-1]
            int j = i ;

            while ( (j>0) && (arr[j-1] > x)) {
                arr[j] = arr[j-1]; // Keo nut lon hon x len 1 vi tri
                j--;

            }

            /* Chen x vao vi tri hop le, j la vi tri dau tien ma a[j] <= x
             * do do gia tri j dung la vi tri can chen x */
            arr[j] = x;

            if (hasSave) {
                new Algorithm(arr).display();
                writeFile("./src/resource/output3.txt" , arr, true);
            }
        }

        return arr;
    }

    /**
     * Searching the indices of elements in array [arr] greater than value.
     * Printing and writing all indices to the console screen and file OUTPUT4.TXT separated by space.
     * @param arr   Input array using for searching
     * @param value The value for searching
     */
    public void search(float[] arr, float value) {
        writeFile("./src/resource/output4.txt" , arr);
        String fileContent = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
                fileContent = fileContent.concat(i + " ");
            }
        }
        if (fileContent.equals("")) {
            fileContent += -1;
        }

        System.out.println("Indexs: "+ fileContent);
        writeFile("./src/resource/output4.txt", fileContent, true);

    }

    /**
     * Searching by using the Binary Search algorithm. Returning the first index of
     * value if it is present in array arr, otherwise, return -1. The index also
     * written to file OUTPUT5.TXT and shown on the console screen.
     * @param arr   Input array using for searching
     * @param left  The left index
     * @param right The right index
     * @param value The value for searching
     * @return The index of the element if found, otherwise, return -1
     * */
    @Override
    public int binarySearch(float[] arr, int left, int right, float value) {
        arr = insertionSort(arr);
        int indexToLook = (int) Math.floor((right + left) / 2);
        while ((right > left)) {
            if (arr[indexToLook] >= value) { // case to search on the left
                right = indexToLook;
            } else {
                left = indexToLook + 1;
            }
            indexToLook = (int) Math.floor((left + right) / 2);
        }
        if (arr[indexToLook] == value) {
            String content = indexToLook + "";
            System.out.println("Index of first element: " + indexToLook);
            writeFile("./src/resource/output5.txt" , content, false);
            return indexToLook;
        }

        System.out.println("No result");
        writeFile("./src/resource/output5.txt" , "-1", false);
        return -1;
    }

    /**
     * Searching by using the Binary Search algorithm. Returning the first index of
     * value if it is present in array arr, otherwise, return -1. The index also
     * written to file OUTPUT5.TXT and shown on the console screen.
     * @param arr   Input array using for searching
     * @param value The value for searching
     * @return The index of the element if found, otherwise, return -1
     * */
    public int binarySearch(float[] arr, float value) {
        int left = 0;
        int right = arr.length - 1 ;
        return binarySearch(arr, left, right, value);
    }

    /** Hàm hiển thị menu */
    public void showMenu() {
        System.out.println(
                        "\n+-------------------Menu----------------+" +
                        "\n| 1.Input                               |" +
                        "\n| 2.Out                                 |" +
                        "\n| 3.Bubble sort                         |" +
                        "\n| 4.Selection sort                      |" +
                        "\n| 5 Insertion sort                      |" +
                        "\n| 6.Search > value                      |" +
                        "\n| 7.Search = value                      |" +
                        "\n| 8.Compare Sorts                       |" +
                        "\n| 9.Compare Sorts Sample                |" +
                        "\n| 0.Exit                                |" +
                        "\n+--------------------------------------.+");
        System.out.print("Your choice: ");
    }

    /** Tạo mảng đã được sắp xếp */
    public static float[] sortedArray(int length) {
        float[] arr = new float[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (float) (i + Math.random());
        }

        return arr;
    }

    /** Tạo mảng sắp xếp ngược */
    public static float[] reverseArray(int length) {
        float[] arr = new float[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (float) (- i - Math.random());
        }

        return arr;
    }

    /** Tạo mảng xáo trộn ngẫu nhiên */
    public static float[] originalArray(int length) {
        float[] arr = new float[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (float) ((i+1) * Math.random());
        }

        return arr;
    }
}
