package IV_BinarySearch.I_Easy;
//https://leetcode.com/problems/find-peak-element/
public class XIII_FindPeakElement {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 5};
        System.out.println(findPeakElement(arr));
    }

    //Optimal Solution
    public static int findPeakElement(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start<end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid + 1]){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }

    //Better Solution
    // public static int findPeakElement(int[] arr){
    //     int n = arr.length;
    //     if(n == 1){
    //         return 0;
    //     }
    //     else if(arr[0] > arr[1]){
    //         return 0;
    //     }
    //     else if(arr[n-1] > arr[n-2]){
    //         return n-1;
    //     }

    //     int low = 1;
    //     int high = n-2;

    //     while(low <= high){
    //         int mid = low + (high - low) / 2;

    //         if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
    //             return mid;
    //         }
    //         else if(arr[mid] > arr[mid-1]){
    //             low = mid + 1;
    //         }
    //         else{
    //             high = mid - 1;
    //         }
    //     }

    //     return - 1;
    // }

    //Brute force
    //O(N)
    // public static int findPeakElement(int[] arr){
    //     for(int i=0; i<arr.length; i++){
    //         if((i==0 || arr[i-1] < arr[i]) && (i==arr.length-1 || arr[i+1] < arr[i])){
    //             return i;
    //         }
    //     }

    //     return -1;
    // }
}
