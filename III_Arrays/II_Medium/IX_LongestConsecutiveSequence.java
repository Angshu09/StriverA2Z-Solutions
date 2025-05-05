package III_Arrays.II_Medium;

import java.util.Arrays;
import java.util.HashSet;

//https://www.interviewbit.com/problems/longest-consecutive-sequence/
public class IX_LongestConsecutiveSequence {
    //A consecutive sequence is a sequence of numbers, items, or events that follow each other in a continuous, unbroken order. In mathematics, consecutive numbers are integers that follow each other in sequence, where each number is exactly one greater than the preceding number
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveBetter(arr));
        System.out.println(longestConsecutiveOptimal(arr));

    }

    public static int longestConsecutiveOptimal(final int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int longest = 1;
        HashSet<Integer> set = new HashSet<>();

        // Insert all elements into the set
        for (int num : arr) {
            set.add(num);
        }

        // Iterate through each element in the set
        for (int num : set) {
            // Check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int count = 1;
                int x = num;

                // Count the length of the consecutive sequence
                while (set.contains(x + 1)) {
                    x++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static int longestConsecutiveBetter(final int[] arr) {
        // n log n + n - TC
        Arrays.sort(arr);
        int lastSmallest = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;

        for(int i=0; i<arr.length; i++){
            if(arr[i]-1 == lastSmallest){
                count++;
                lastSmallest = arr[i];
            }
            else if(arr[i] != lastSmallest){
                count = 1;
                lastSmallest = arr[i];
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }
}
