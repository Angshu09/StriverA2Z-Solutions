package II_SortingTechniques;


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // Initialize an unsorted array
        int[] arr = {8, 2, 1, 9, 10};

        // Call bubble sort on the array
        bubbleSorting(arr);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    // Function to sort the array using bubble sort algorithm.

    // Normal
    // public static void bubbleSorting(int arr[]) {
    //     for (int i = 0; i < arr.length; i++) {
    //         boolean swap = false;
    //         for (int j = 1; j < arr.length - i; j++) {
    //             if (arr[j - 1] > arr[j]) {
    //                 int temp = arr[j - 1];
    //                 arr[j - 1] = arr[j];
    //                 arr[j] = temp;
    //                 swap = true;
    //             }
    //         }
    //         if (!swap) {
    //             return;
    //         }
    //     }
    // }

    // Using Recursion
    public static void bubbleSorting(int arr[]) {
        sort(arr, arr.length);
    }

    public static void sort(int[] arr, int n) {
        if (n == 1) return;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        sort(arr, n - 1);
    }

    // TC - O(n^2)
}
