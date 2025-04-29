package III_Arrays.I_Easy;
//https://leetcode.com/problems/missing-number/description/
public class IX_FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println(findTheMissingNumber(arr));
    }

    private static int findTheMissingNumber(int[] nums){
        for(int i=0; i<nums.length;){
            int correct = nums[i];

            if(correct < nums.length && nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else{
                i++;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }

        return nums.length;
    }
}
