package III_Arrays.II_Medium;
//https://leetcode.com/problems/sort-colors/description/
import java.util.Arrays;

public class II_SortArrayOfZerosOnesTwos {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
//        sort012Better(arr);
        sort012Optimal(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort012Optimal(int[] arr){
        //This is DNF (Dutch National Flag Algo)
        //Here we have some rules like -
        //(0 to low-1) ---> 0
        //(low to mid-1) ---> 1
        //(mid to high) ---> unsorted
        //(high+1 to n-1) ---> 2
        // {0000 1111 210120 2222} like this

        //0 to mid-1 every thing will be sorted(0000011111...) & high+1 to n-1 everything will be sorted(22222...)
        //only mid to high is unsorted, my task is to somehow sort this portion

        int n=arr.length;
        if(n == 1){
            return;
        }

        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid<=high){
            if(arr[mid] == 0){
                swap(arr, mid, low);
                mid++;
                low++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }

    static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //this is better solution, not optimal
    private static void sort012Better(int[] arr){
        //count the 0, 1 and 2
        // Overall TC - O(n), SC - O(1)
        int c0=0;
        int c1 =0;
        int c2 = 0;

        for(int num: arr){
            if(num == 0){
                ++c0;
            }
            else if(num == 1){
                ++c1;
            }
            else{
                ++c2;
            }
        }

        int i= 0;
        while(c0!=0){
            arr[i] = 0;
            i++;
            c0--;
        }

        while(c1!= 0){
            arr[i] = 1;
            i++;
            c1--;
        }

        while(c2 != 0){
            arr[i] = 2;
            i++;
            c2--;
        }
    }

    //Brute force will be any kind of sorting algo
}
