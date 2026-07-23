package IV_BinarySearch.I_Easy;

public class IX_SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        System.out.println(search(arr, 0));
    }

    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            //If we find target at mid index well and good
            if(nums[mid] == target){
                return true;
            }
            //This is the another check, here i avoid the  search space simply
            else if(nums[mid] == nums[start] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }
            //check for both left ad right which is sorted
            //it checks for left
            else if(nums[start] <= nums[mid]){
                //it checks that the target is actually in between the sorted portion
                //start-mid
                if(nums[start] <= target && nums[mid] >= target){
                    end = mid-1;
                }
                else{
                    start = mid + 1;
                }
            }
            //it checks for right
            else{
                //it checks that the target is actually in between the sorted portion
                //mid-end
                if(nums[mid] <= target && nums[end] >= target){
                    start = mid+ 1;

                }
                else{
                    end = mid-1;
                }
            }
        }
        return false;
    }
}
