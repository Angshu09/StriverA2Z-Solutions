package VII_Recursion.II_Medium;
//https://leetcode.com/problems/subsets/description/
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] nums = {3, 1, 2};
        generateSubsets(0, ans, new ArrayList<>(), nums);

        for(int i=0; i<ans.size(); i++){
            int[] temp = new int[ans.get(i).size()];
            for(int j=0; j<temp.length; j++){
                temp[j] = ans.get(i).get(j);
            }
            System.out.print(Arrays.toString(temp)+", ");
        }
    }

    private static void generateSubsets(int i, ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> subset, int[] nums) {

        if (i == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        // Include
        subset.add(nums[i]);
        generateSubsets(i + 1, ans, subset, nums);

        // Exclude
        subset.remove(subset.size() - 1);
        generateSubsets(i + 1, ans, subset, nums);
    }
}
