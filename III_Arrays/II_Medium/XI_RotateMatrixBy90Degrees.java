package III_Arrays.II_Medium;
// https://leetcode.com/problems/rotate-image/description/

import java.util.Arrays;

public class XI_RotateMatrixBy90Degrees {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Brute-force approach: returns a new rotated matrix
        int[][] ans = rotateBrute(matrix);
        for (int[] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }

        // Optimal in-place rotation of the original matrix
        rotateOptimal(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    // Brute-force method
    // TC: O(n^2), SC: O(n^2) for extra matrix
    public static int[][] rotateBrute(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];

        // Copy elements to their rotated positions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - i - 1] = matrix[i][j];
            }
        }

        return ans;
    }

    // Optimal method: rotate matrix in-place by 90 degrees clockwise
    // TC: O(n^2), SC: O(1) (in-place)
    public static void rotateOptimal(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }

    // Helper function to swap two elements in the matrix
    private static void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    // Helper function to reverse a 1D array (used to reverse rows)
    private static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
