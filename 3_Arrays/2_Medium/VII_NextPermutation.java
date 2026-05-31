package III_Arrays.II_Medium;
//https://leetcode.com/problems/next-permutation/description/
import java.util.Arrays;

public class VII_NextPermutation {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;

        // Step 1: Find the first index from the right where nums[i] < nums[i + 1]
        // This is the 'pivot' point where the order breaks descending trend
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // Step 2: If no such index found, this is the last permutation
        // Reverse the entire array to return to the first permutation
        if(idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the smallest element greater than nums[idx] from the right side
        // This ensures we get the next greater permutation
        for(int i = n - 1; i > idx; i--) {
            if(nums[i] > nums[idx]) {
                swap(nums, idx, i);
                break;
            }
        }

        // Step 4: Reverse the suffix starting from idx + 1 to end
        // This gives the next smallest lexicographical order
        reverse(nums, idx + 1, n - 1);
    }

    // Helper method to reverse array between two indices
    private static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Helper method to swap two elements in array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
