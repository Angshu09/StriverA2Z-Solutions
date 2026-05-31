package IV_BinarySearch.I_Easy;
//https://leetcode.com/problems/binary-search/description/
public class I_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(arr, target));
        System.out.println(binarySearch(arr, target, 0, arr.length-1));
    }

    public static int search(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start) / 2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = start + (end-start) / 2;
        if(arr[mid] == target){
            return mid;
        }
        if(target < arr[mid]){
            return binarySearch(arr, target, start, mid-1 );
        }

        return binarySearch(arr, target, mid+1, end);

    }
}
