package VII_Recursion.II_Medium;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 2, 1, 0, 7, 8, 67, 4};

        mergeSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high){
        if(low == high){
            return;
        }

        int mid = (low+high)/2;

        mergeSort(arr, 0, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        int[] temp = new int[high-low+1];
        int i = 0;

        while(left <=mid && right <=high){
            if(arr[left] <= arr[right]){
                temp[i] = arr[left];
                left++;
            }
            else{
                temp[i] = arr[right];
                right++;
            }
            i++;
        }

        while(left<=mid){
            temp[i] = arr[left];
            left++;
            i++;
        }

        while(right<=high){
            temp[i] = arr[right];
            right++;
            i++;
        }

        for(int j = low; j<=high; j++){
            arr[j] = temp[j-low];
        }

    }
}
