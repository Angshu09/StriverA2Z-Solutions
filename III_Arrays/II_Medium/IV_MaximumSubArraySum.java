package III_Arrays.II_Medium;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-subarray/description/
public class IV_MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArrayBrute(arr));
        System.out.println(maxSubArrayOptimal(arr));
        printMaxSubArray(arr);
    }

    public static void printMaxSubArray(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];
        int start = 0;
        int end = 0;
        int s = 0;

        for (int i = 1; i < arr.length; i++) {
            if (currMax + arr[i] < arr[i]) {
                currMax = arr[i];
                s = i;
            } else {
                currMax += arr[i];
            }

            if (currMax > maxSoFar) {
                maxSoFar = currMax;
                start = s;
                end = i;
            }
        }

        // Print the subarray
        System.out.println("Maximum subarray sum: " + maxSoFar);
        System.out.print("Subarray: ");
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, start, end + 1)));
    }

    public static int maxSubArrayOptimal(int[] arr) {
        //kadane's algo
        //O(n) tc
        int n = arr.length;
        if(n == 1) return arr[0];

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            sum += arr[i];
            max = Math.max(max, sum);

            if(sum < 0){
                sum = 0; //There is no point to carry a negative sum, because negative will reduce my sum more
                //always carry positive
            }
        }

        return max;
    }

     public static int maxSubArrayBrute(int[] nums) {
         //Brute force solution
         //O(N^2)

         int max = Integer.MIN_VALUE;

         for(int i=0; i<nums.length; i++){
             int sum = 0;
             for(int j=i; j<nums.length; j++){
                 sum += nums[j];
                 max = Math.max(sum, max);
             }
         }

         return max;
     }

}
