package IV_BinarySearch.I_Easy;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class X_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findMin(arr));
    }

    //Best optimised code
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[low] <= nums[high]){
                ans = Math.min(ans, nums[low]);
                break;
            }
            else if(nums[low] <= nums[mid]){
                ans = Math.min(ans, nums[low]);
                low = mid+1;
            }
            else{
                ans = Math.min(nums[mid], ans);
                high = mid - 1;
            }
        }

        return ans;
    }

    //Using Binary search
    //O(log n)
    // public static int findMin(int[] nums) {
    //     int low = 0;
    //     int high = nums.length-1;
    //     int ans = Integer.MAX_VALUE;

    //     while(low <= high){
    //         int mid = low + (high - low) / 2;

    //         if(nums[mid] >= nums[low]){
    //             ans = Math.min(nums[low], ans);
    //             low = mid+1;
    //         }
    //         else{
    //             ans = Math.min(nums[mid], ans);
    //             high = mid - 1;
    //         }
    //     }

    //     return ans;
    // }

    //Brute force solution
    //Simple Linear search
    //O(N)
    // public static int findMin(int[] nums) {
    //     int min = nums[0];
    //     for(int i=1; i<nums.length; i++){
    //         min = Math.min(min, nums[i]);
    //     }
    //     return min;
    // }

}
