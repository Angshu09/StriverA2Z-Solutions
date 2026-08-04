package VII_Recursion.II_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubSetSumII {

    public static void main(String[] args) {

        int[] nums = {1, 2, 2};

        // ---------------- Normal Approach (Using HashSet) ----------------
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        helperHashSet(nums, 0, new ArrayList<>(), set);

        for (ArrayList<Integer> temp : set) {
            ans.add(temp);
        }

        System.out.println("Normal Approach (HashSet):");
        System.out.println(ans);

        // ---------------- Better Approach ----------------
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), result);

        System.out.println("\nBetter Approach:");
        System.out.println(result);
    }

    // ---------------- Normal Approach ----------------
    public static void helperHashSet(int[] nums, int i,
                                     ArrayList<Integer> subset,
                                     HashSet<ArrayList<Integer>> set) {

        if (i == nums.length) {
            set.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        helperHashSet(nums, i + 1, subset, set);

        subset.remove(subset.size() - 1);
        helperHashSet(nums, i + 1, subset, set);
    }

    // ---------------- Better Approach ----------------
    private static void helper(int[] arr, int index,
                               ArrayList<Integer> subset,
                               ArrayList<ArrayList<Integer>> result) {

        result.add(new ArrayList<>(subset));

        for (int i = index; i < arr.length; i++) {

            if (i != index && arr[i] == arr[i - 1]) {
                continue;
            }

            subset.add(arr[i]);
            helper(arr, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}