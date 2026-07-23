package IV_BinarySearch.I_Easy;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class VI_FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(arr, target)));

    }

    //Simple bs technique, merge first and last occurrence
    public static int[] searchRange(int[] arr, int target){
        int firstOccurrence = search(arr, target, true);
        if(firstOccurrence == -1){
            return new int[]{-1, -1};
        }
        int lastOccurrence = search(arr, target, false);
        return new int[]{firstOccurrence, lastOccurrence};
    }
    private static int search(int[] arr, int target, boolean isFirst){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end-start) / 2;

            if(arr[mid] == target){
                ans = mid;
                if(isFirst){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid+1;
            }


        }

        return ans;
    }

    //This approach is using the concept of lowerBound and upperBound
    // public static int[] searchRange(int[] arr, int target){
    //     int lb = lowerBound(arr, target);
    //     if(lb == arr.length || arr[lb] != target){
    //         return new int[]{-1, -1};
    //     }
    //     return new int[]{lb, upperBound(arr, target)-1};
    // }
    // private static int lowerBound(int[] arr, int target){
    //     int start = 0;
    //     int end = arr.length-1;
    //     int ans = arr.length;

    //     while(start <= end){
    //         int mid = start + (end - start) / 2;

    //         if(arr[mid] >= target){
    //             ans = mid;
    //             end = mid - 1;
    //         }
    //         else{
    //             start = mid + 1;
    //         }
    //     }

    //     return ans;
    // }
    // private static int upperBound(int[] arr, int target){
    //     int start = 0;
    //     int end = arr.length-1;
    //     int ans = arr.length;

    //     while(start <= end){
    //         int mid = start + (end - start) / 2;

    //         if(arr[mid] > target){
    //             ans = mid;
    //             end = mid - 1;
    //         }
    //         else{
    //             start = mid + 1;
    //         }
    //     }

    //     return ans;
    // }
}
