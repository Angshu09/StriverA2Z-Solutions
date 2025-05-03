package III_Arrays.II_Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class VI_RearrangeArrayElementsBySign {
    public static void main(String[] args) {
       int[] arr = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeElementsOptimal(arr)));

//       rearrangeElementsBrute(arr);
//        System.out.println(Arrays.toString(arr));
    }

    // Function to rearrange an array such that positive and negative numbers
    // appear alternately, starting with a positive number.
    // Assumes equal number of positive and negative elements.
    // Time Complexity: O(n), Space Complexity: O(n)
    private static int[] rearrangeElementsOptimal(int[] arr) {
        int n = arr.length;

        // If the array has only one element, return it as-is
        if (n == 1) return arr;

        // Create a new array to store the rearranged result
        int[] ans = new int[n];

        // Index for placing positive numbers at even indices
        int positiveIndex = 0;

        // Index for placing negative numbers at odd indices
        int negativeIndex = 1;

        // Traverse original array and place positive and negative numbers
        // in alternating positions in the result array
        for (int num : arr) {
            if (num > 0) {
                // Place positive number at even index
                ans[positiveIndex] = num;
                positiveIndex += 2;
            } else {
                // Place negative number at odd index
                ans[negativeIndex] = num;
                negativeIndex += 2;
            }
        }

        // Return the rearranged array
        return ans;
    }



    // Function to rearrange elements of the array such that:
    // Positive and negative numbers appear alternately, starting with positive.
    // Assumes the array has equal number of positive and negative elements.
    // This is a brute-force approach using extra space (two ArrayLists).
    private static void rearrangeElementsBrute(int[] arr) {
        int n = arr.length;

        // If the array has only one element, nothing to rearrange
        if (n == 1) return;

        // Create separate lists to store positive and negative numbers
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        // Step 1: Separate positive and negative numbers into their respective lists
        for (int num : arr) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        // Step 2: Rearrange elements in alternating order:
        // Even indices get positive numbers, odd indices get negative numbers
        for (int i = 0; i < n / 2; i++) {
            arr[2 * i] = positive.get(i);     // Place positive number at even index
            arr[2 * i + 1] = negative.get(i); // Place negative number at odd index
        }
        // If array has not equal no of elements then, the code may throw IndexOutOfBoundsException.
    }

}
