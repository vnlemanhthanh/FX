package main;

public interface IAlgorithm {

    /**
     * Writing the array read from input array arr to file
     * @param fileName The file name of file to write value
     * @param arr      The input float array
     */
    void writeFile(String fileName, float arr[]);

    /**
     * Reading the file then input to the array arr
     * @param fileName The file name of file to read
     * @return Returning a array read from the file
     */
    float[] readFile(String fileName) ;

    /**
     * Sorting the input array arr using Bubble Sort algorithm.
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Bubble Sort algorithm
     */
    float[] bubbleSort(float arr[]);

    /**
     * Sorting the input array arr using Selection Sort algorithm.
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Selection Sort algorithm
     */
    float[] selectionSort(float arr[]);

    /**
     * Sorting the input array arr using Insertion Sort algorithm.
     * @param arr Input array using for searching
     * @return Returning a sorted array by using the Insertion Sort algorithm
     */
    float[] insertionSort(float arr[]);

    /**
     * Searching the indices of elements in array [arr] greater than value. Printing
     * and writing all indices to the console screen and file OUTPUT4.TXT separated by space.
     * @param arr   Input array using for searching
     * @param value The value for searching
     */
    void search(float[] arr, float value);

    /**
     * Searching by using the Binary Search algorithm. Returning the first index of
     * value if it is present in array arr, otherwise, return -1. The index also
     * written to file OUTPUT5.TXT and shown on the console screen.
     * @param arr   Input array using for searching
     * @param left  The left index
     * @param right The right index
     * @param value The value for searching
     * @return The index of the element if found, otherwise, return -1
     */
    public int binarySearch(float arr[], int left, int right, float value);

}
