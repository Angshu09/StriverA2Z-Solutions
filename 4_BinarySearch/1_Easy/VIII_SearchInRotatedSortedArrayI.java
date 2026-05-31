package IV_BinarySearch.I_Easy;

public class VIII_SearchInRotatedSortedArrayI {
    public static void main(String[] args) {
        int[] arr ={4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            //If we find target at mid index well and good
            if(nums[mid] == target){
                return mid;
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

        return -1;
    }


}
