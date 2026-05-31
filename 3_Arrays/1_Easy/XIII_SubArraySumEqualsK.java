package III_Arrays.I_Easy;

//https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;

public class XIII_SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        System.out.println(subarraySum(arr, k));
    }

    private static int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Handle case when subarray starts from index 0

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            int rem = sum - k;

            if (map.containsKey(rem)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
