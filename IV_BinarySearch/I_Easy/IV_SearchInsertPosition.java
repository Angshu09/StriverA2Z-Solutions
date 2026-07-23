package IV_BinarySearch.I_Easy;
//https://leetcode.com/problems/search-insert-position/
public class IV_SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,2, 4, 7, 8, 10};
        int target = 3;
        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;
        int ans = nums.length;
        while(start <= end){
            int mid = start + (end-start) / 2;
            if(nums[mid] >= target){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;

    }

}
