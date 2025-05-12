package III_Arrays.III_Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class I_PascalTriangle {
    public static void main(String[] args) {
        int n=6;
        ArrayList<ArrayList<Integer>> ans = generate(n);
        for(ArrayList<Integer> list: ans){
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        // This will hold the entire Pascal's Triangle
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // Loop through each row from 1 to numRows
        for(int i = 1; i <= numRows; i++) {
            // For each row, compute its content using findRow() and add to result
            ans.add(findRow(i));
        }

        return ans; // Return the full triangle
    }

    // Helper function to generate the nth row of Pascal's Triangle
    private static ArrayList<Integer> findRow(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        // Base case: if it's the first row, just return [1]
        if(n == 1) {
            ans.add(1);
            return ans;
        }

        int res = 1; // First element of every row is always 1
        ans.add(res);

        // Compute the intermediate values using binomial coefficients
        // res = res * (n-i) / i gives the next element in the row
        for(int i = 1; i <= n - 2; i++) {
            res = res * (n - i);
            res = res / i;
            ans.add(res);
        }

        ans.add(1); // Last element of every row is also 1
        return ans; // Return the constructed row
    }
}
