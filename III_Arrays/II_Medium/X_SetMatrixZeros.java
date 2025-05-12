package III_Arrays.II_Medium;

import java.util.Arrays;

//https://leetcode.com/problems/set-matrix-zeroes/description/
public class X_SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

//        setZerosBetter(matrix);
        setZerosOptimal(matrix);
        for(int[] array: matrix){
            System.out.println(Arrays.toString(array));
        }

    }

    private static void setZerosBetter(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rowArr = new int[n];
        int[] colArr = new int[m];

        for(int i=0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == 0){
                    rowArr[i] = 1;
                    colArr[j] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(rowArr[i] == 1 || colArr[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }


    }

    private static void setZerosOptimal(int[][] matrix) {
        // Get the dimensions of the matrix
        int n = matrix.length;
        int m = matrix[0].length;

        // Variable to track whether the first column needs to be zeroed
        int col0 = 1;

        // First pass: use the first row and first column as markers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If a zero is found in the matrix
                if (matrix[i][j] == 0) {
                    // Mark the corresponding row by setting the first element of the row to 0
                    matrix[i][0] = 0;

                    if (j != 0) {
                        // Mark the corresponding column by setting the first element of the column to 0
                        matrix[0][j] = 0;
                    } else {
                        // If the zero is in the first column, set col0 to 0
                        col0 = 0;
                    }
                }
            }
        }

        // Second pass: start from (1,1) and update cells based on markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // If current cell is not already zero
                if (matrix[i][j] != 0) {
                    // Check the row and column markers
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Finally, handle the first row if needed
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle the first column if needed
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }


}
