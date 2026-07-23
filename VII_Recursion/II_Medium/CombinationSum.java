package VII_Recursion.II_Medium;

import java.util.ArrayList;

//https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        ArrayList<ArrayList<Integer>> ans = combinationSum(arr, target);

        for(int i=0; i<ans.size(); i++){
            System.out.print("[ ");
            for(int j=0; j<ans.get(i).size(); j++){

                System.out.print(ans.get(i).get(j)+ " ");

            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();

        helper(0, target, combination, ans, arr);

        return ans;
    }

    public static void helper(int i, int target, ArrayList<Integer> combination, ArrayList<ArrayList<Integer>> ans, int[] arr){
        if(i == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(combination));
            }
            return;
        }

        if(arr[i] <= target){
            combination.add(arr[i]);
            helper(i, target-arr[i], combination, ans, arr);
            combination.remove(combination.size() - 1);
        }

        helper(i+1, target, combination, ans, arr);

    }
}
