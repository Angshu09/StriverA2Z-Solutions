package III_Arrays.III_Hard;
//https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

import java.util.HashMap;

public class V_LargestSubArrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(findLargestSubArraySumEqualZero(arr));
    }

    private static int findLargestSubArraySumEqualZero(int[] arr){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];

            if(sum == 0) {
                max = i + 1;
            } else if(map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;

    }
}
