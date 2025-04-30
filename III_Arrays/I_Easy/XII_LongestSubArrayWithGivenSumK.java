package III_Arrays.I_Easy;

import java.util.HashMap;

public class XII_LongestSubArrayWithGivenSumK {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        int k = 5;
        System.out.println(findLongestSubArrayLength(arr, k));
        System.out.println(findLongestSubArrayLengthOptimal(arr, k));
    }

    //It finds the longest sub array length
    //Better solution
    public static int findLongestSubArrayLength(int[] arr, int k) {
        int sum = 0;
        int len = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            if(sum == k){
                len = Math.max(len, i+1);
            }

            int rem = sum - k;

            if(map.containsKey(rem)){
                int tempLen = i - map.get(rem);
                len = Math.max(len, tempLen);
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        //TC - O(n)
        //SC - O(n)

        return len;

    }

    //Optimal approach
    //It works if all the elements are positive
    private static int findLongestSubArrayLengthOptimal(int[] arr, int k){
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen = 0;

        while(right < arr.length){
            sum += arr[right];

            if(sum > k && left <= right){
                sum -= arr[left];
                left++;
            }

            if(sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

    //O(2N)
}
