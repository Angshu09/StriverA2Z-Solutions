package II_SortingTechniques;

import java.util.Arrays;

//Approach 1
/*
public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{3, 8, 1, 4, 12, 10})));
    }

    private static int[] quickSort(int[] arr) {
        qs(arr, 0, arr.length-1);
        return arr;
    }

    private static void qs(int[] arr, int low, int high){
        if(low < high){
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex-1);
            qs(arr, pIndex+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i < j){
            while(arr[i] <= pivot && i <= high-1){
                i++;
            }

            while(arr[j] >= pivot && j >= low+1){
                j--;
            }

            if(i < j){
                swap(arr, i, j);

            }
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  =temp;
    }

    //TC - n log n
}
*/


//Approach 2
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
