package III_Arrays.I_Easy;

/*
    Given an array of integers nums, return the value of the largest element in the array


    Examples:
    Input: nums = [3, 3, 6, 1]

    Output: 6

    Explanation: The largest element in array is 6
*/

public class I_LargestElement {

    public static void main(String[] args) {
        System.out.println(largestElement(new int[]{3, 12, 67, 1, 23, 0, 123}));
    }

    public static int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        return max;
    }

}
