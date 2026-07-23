package VII_Recursion.II_Medium;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int partitionIndex = findPartitionIndex(arr, low, high);
            quickSort(arr, low, partitionIndex-1);
            quickSort(arr, partitionIndex+1, high);

        }
    }

    private static int findPartitionIndex(int[] arr, int low, int high){
        int pivot = low;

        int i=low;
        int j=high;

        while(i<j){
            while(arr[i]<=arr[pivot] && i<=high){
                i++;
            }

            while(arr[j]>arr[pivot] && j>=low){
                j--;
            }

            if(i<j){
                swap(arr, i, j);
            }
        }

        swap(arr, pivot, j);

        return j;

    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
