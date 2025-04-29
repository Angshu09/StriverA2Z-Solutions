package II_SortingTechniques;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        // Initialize an unsorted array
        int[] arr = {8, 2, 1, 9, 10};

        // Call insertion sort on the array
        insertionSorting(arr, 1);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    /*
    // Iterative version of Insertion Sort (Commented out)
    public static void insertionSorting(int arr[]) {
        // Traverse the array from the second element
        for(int i = 0; i < arr.length - 1; i++) {
            // Move the current element to its correct position in the sorted part
            for(int j = i + 1; j > 0; j--) {
                // Swap if previous element is greater
                if(arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    // Stop if no more swaps are needed
                    break;
                }
            }
        }
    }
    */

    // Time Complexity: O(n^2) in worst case

    // Recursive Insertion Sort with actual shifting (not swapping)
    public static void insertionSorting(int[] arr, int i) {
        // Base case: if we reach the end, stop
        if (i == arr.length) return;

        // Store the current element
        int key = arr[i];
        int j = i - 1;

        // Shift elements of the sorted part that are greater than key
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        // Insert the key at the correct position
        arr[j + 1] = key;

        // Recur for the next element
        insertionSorting(arr, i + 1);
    }
}
