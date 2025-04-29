package II_SortingTechniques;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        // Initialize an unsorted array
        int[] arr = {8, 2, 1, 9, 10};

        // Call selection sort on the array
        selectionSorting(arr);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    // Function to perform selection sort in descending order
    static void selectionSorting(int[] arr) {
        // Iterate over the array from start to end
        for(int i = 0; i < arr.length; i++) {
            // Find the index of the maximum element in the unsorted part
            int maxindex = findMax(arr, 0, arr.length - i - 1);

            // Swap the maximum element with the last element of the unsorted part
            swap(arr, maxindex, arr.length - i - 1);
        }
    }

    // Function to find the index of the maximum element between start and end
    static int findMax(int[] arr, int start, int end) {
        int max = 0;
        for(int i = start; i <= end; i++) {
            if(arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    // Function to swap two elements in the array
    static void swap(int[] arr, int max, int end) {
        int temp = arr[max];
        arr[max] = arr[end];
        arr[end] = temp;
    }

    // Time Complexity: O(n^2)
}
