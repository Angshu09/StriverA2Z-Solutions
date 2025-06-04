package III_Arrays.III_Hard;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/4sum/description/
public class IV_FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(Arrays.toString(fourSum(nums, 0).toArray()));
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        //O(n^3)

        // Step 1: Sort the array to use the two-pointer approach
        Arrays.sort(nums);

        // This will store all the unique quadruplets
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // First loop to fix the first element
        for (int i = 0; i < n; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Second loop to fix the second element
            for (int j = i + 1; j < n; j++) {
                // Skip duplicates for the second element
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;

                // Now apply two-pointer approach for remaining two elements
                int k = j + 1;
                int l = n - 1;

                // Two-pointer logic
                while (k < l) {
                    // Use long to avoid integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        // Valid quadruplet found
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);

                        // Move both pointers and skip duplicates
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                    else if (sum < target) {
                        k++; // Need a bigger sum
                    }
                    else {
                        l--; // Need a smaller sum
                    }
                }
            }
        }

        // Return the list of all unique quadruplets
        return ans;
    }
}
