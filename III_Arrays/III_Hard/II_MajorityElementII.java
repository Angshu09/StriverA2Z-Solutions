package III_Arrays.III_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

// https://leetcode.com/problems/majority-element-ii/description/
public class II_MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("Brute Force: " + Arrays.toString(findMajorityEleBrute(arr).toArray()));
        System.out.println("Better: " + Arrays.toString(findMajorityEleBetter(arr).toArray()));
        System.out.println("Optimal: " + Arrays.toString(findMajorityEleOptimal(arr).toArray()));
    }

    // 🔹 Brute Force Approach - TC: O(n^2), SC: O(1)
    private static ArrayList<Integer> findMajorityEleBrute(int[] arr) {
        int n = arr.length;
        int mm = n / 3;
        ArrayList<Integer> ans = new ArrayList<>();

        // Step 1: Iterate over every element
        for (int i = 0; i < n; i++) {

            // Step 2: Avoid checking already added elements
            if (ans.size() == 0 || ans.get(0) != arr[i]) {
                int count = 0;

                // Step 3: Count frequency of current element
                for (int j = 0; j < n; j++) {
                    if (arr[j] == arr[i]) {
                        count++;
                    }
                }

                // Step 4: Add if frequency > n/3
                if (count > mm) {
                    ans.add(arr[i]);
                }
            }

            // Step 5: Max 2 elements can be > n/3
            if (ans.size() == 2) break;
        }

        return ans;
    }

    // 🔹 Better Approach using HashMap - TC: O(n), SC: O(n)
    private static ArrayList<Integer> findMajorityEleBetter(int[] arr) {
        int n = arr.length;
        int mm = n / 3;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Store frequencies in map
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            // Step 2: If frequency > n/3 and not already added
            if (map.get(arr[i]) > mm && !ans.contains(arr[i])) {
                ans.add(arr[i]);
            }

            // Step 3: Break if more than 2 found
            if (ans.size() > 2) {
                break;
            }
        }

        return ans;
    }

    // 🔹 Optimal Approach using Moore’s Voting Algorithm - TC: O(n), SC: O(1)
    private static ArrayList<Integer> findMajorityEleOptimal(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;

        // Step 1: Find potential majority elements (at most 2)
        for (int i = 0; i < nums.length; i++) {
            if (cnt1 == 0 && nums[i] != el2) {
                cnt1 = 1;
                el1 = nums[i];
            } else if (cnt2 == 0 && nums[i] != el1) {
                cnt2 = 1;
                el2 = nums[i];
            } else if (nums[i] == el1) {
                cnt1++;
            } else if (nums[i] == el2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Step 2: Count actual occurrences of el1 and el2
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == el1) cnt1++;
            if (num == el2) cnt2++;
        }

        // Step 3: Check if they appear more than ⌊ n/3 ⌋ times
        int min = nums.length / 3;
        if (cnt1 > min) ans.add(el1);
        if (cnt2 > min) ans.add(el2);

        // Optional: sort result (though not needed)
        Collections.sort(ans);

        return ans;
    }
}
