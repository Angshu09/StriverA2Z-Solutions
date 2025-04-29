package II_SortingTechniques;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // Initialize an unsorted array
        int[] arr = {9, 5, 2, 7, 1, 6};

        // Call merge sort on the full array
        // mergeSort(arr, 0, arr.length - 1);

        // Print the sorted array
        // System.out.println("Sorted array: " + Arrays.toString(arr));


        //Testing mergeSort2
        int[] ans = mergeSort2(arr);
        System.out.println(Arrays.toString(ans));

    }


    /*
    //Approach 1
    // Merge Sort function (recursive)
    static void mergeSort(int arr[], int l, int r) {
        // Base case: if left index is greater or equal to right, return
        if (l >= r) {
            return;
        }

        // Find the middle index
        int mid = l + (r - l) / 2;

        // Recursively sort the left half
        mergeSort(arr, l, mid);

        // Recursively sort the right half
        mergeSort(arr, mid + 1, r);

        // Merge the two sorted halves
        merge(arr, l, mid, r);
    }

    //Approach 2 merge function
    // Merge two sorted subarrays: arr[l..mid] and arr[mid+1..r]
    static void merge(int[] arr, int l, int mid, int r) {
        int left = l;
        int right = mid + 1;
        int[] temp = new int[r - l + 1];
        int i = 0;

        // Merge elements in sorted order
        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                temp[i] = arr[left];
                left++;
            } else {
                temp[i] = arr[right];
                right++;
            }
            i++;
        }

        // Copy remaining elements from left subarray
        while (left <= mid) {
            temp[i] = arr[left];
            i++;
            left++;
        }

        // Copy remaining elements from right subarray
        while (right <= r) {
            temp[i] = arr[right];
            i++;
            right++;
        }

        // Copy merged elements back into original array
        for (int j = 0; j < temp.length; j++) {
            arr[l + j] = temp[j];
        }
    }
    */


    //Approach 2

    static int[] mergeSort2(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort2(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort2(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    //Approach 2 merge function
    static int[] merge(int[] first, int[] second){
        int[] ans = new int[first.length + second.length];

        int i=0;
        int j=0;
        int k=0;

        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                ans[k] = first[i];
                i++;
            }
            else{
                ans[k] = second[j];
                j++;
            }
            k++;
        }

        while(i < first.length){
            ans[k] = first[i];
            i++;
            k++;
        }

        while(j < second.length){
            ans[k] = second[j];
            j++;
            k++;
        }

        return ans;
    }
}
