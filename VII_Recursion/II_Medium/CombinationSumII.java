package VII_Recursion.II_Medium;

import java.util.ArrayList;
import java.util.Arrays;
//https://leetcode.com/problems/combination-sum-ii/description/
public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        ArrayList<ArrayList<Integer>> ans = combinationSum2(arr, target);

        for(int i=0; i<ans.size(); i++){
            System.out.print("[ ");
            for(int j=0; j<ans.get(i).size(); j++){

                System.out.print(ans.get(i).get(j)+ " ");

            }
            System.out.print("]");
            System.out.println();
        }

    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        Arrays.sort(arr);
        helper(0, target, combination, ans, arr);

        return ans;
    }

    public static void helper(int index, int target, ArrayList<Integer> combination, ArrayList<ArrayList<Integer>> ans, int[] arr){
        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<>(combination);
            ans.add(temp);
            return;
        }

        for(int i=index; i<arr.length; i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]> target) break;

            combination.add(arr[i]);
            helper(i+1, target-arr[i], combination, ans, arr);
            combination.remove(combination.size()-1);
        }
    }
}
