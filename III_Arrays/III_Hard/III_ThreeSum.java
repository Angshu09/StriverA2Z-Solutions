package III_Arrays.III_Hard;
//https://leetcode.com/problems/3sum/
import java.util.*;

public class III_ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(threeSumBrute(arr).toArray()));
        System.out.println(Arrays.toString(threeSumBetter(arr).toArray()));
        System.out.println(Arrays.toString(threeSumOptimal(arr).toArray()));
    }

    // 1. Brute Force Approach
    // TC: O(n^3 * log 3) => O(n^3), SC: O(k), where k is the number of unique triplets
    public static ArrayList<ArrayList<Integer>> threeSumBrute(int[] nums) {
        Set<ArrayList<Integer>> set = new HashSet<>();
        int n = nums.length;

        // Generate all triplets (i, j, k)
        for (int i = 0; i < n; i++) {                  // O(n)
            for (int j = i + 1; j < n; j++) {          // O(n)
                for (int k = j + 1; k < n; k++) {      // O(n)
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);       // O(1), as the list has only 3 elements
                        set.add(temp);                // O(1) amortized
                    }
                }
            }
        }

        // Convert set to list
        return new ArrayList<>(set); // O(k)
    }

    // 2. Better Approach using HashSet
    // TC: O(n^2), SC: O(n^2) for set + O(n) for map at a time
    public static ArrayList<ArrayList<Integer>> threeSumBetter(int[] nums) {
        Set<ArrayList<Integer>> set = new HashSet<>();
        int n = nums.length;

        // Fix one element and find the other two using HashSet
        for (int i = 0; i < n; i++) {                       // O(n)
            HashSet<Integer> map = new HashSet<>();         // O(n) space (worst-case)

            for (int j = i + 1; j < n; j++) {               // O(n)
                int third = -(nums[i] + nums[j]);
                if (map.contains(third)) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    Collections.addAll(temp, nums[i], nums[j], third);
                    Collections.sort(temp);                 // O(1)
                    set.add(temp);                          // O(1)
                }
                map.add(nums[j]);                           // O(1)
            }
        }

        return new ArrayList<>(set);                        // O(k)
    }

    // 3. Optimal Approach using Two Pointer after Sorting
    // TC: O(n^2), SC: O(1) extra (excluding result storage)
    public static ArrayList<ArrayList<Integer>> threeSumOptimal(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums); // O(n log n)

        for (int i = 0; i < n; i++) { // O(n)
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates

            int j = i + 1;
            int k = n - 1;

            while (j < k) { // O(n) in worst case
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    Collections.addAll(temp, nums[i], nums[j], nums[k]);
                    ans.add(temp);

                    j++;
                    k--;

                    // Skip duplicates
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans;
    }
}

