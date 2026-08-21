package VII_Recursion.II_Medium;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];

        //Approach 1
//        helper(nums, ans, ds, freq);

        //Approach 2
        helper(nums, 0, ans);


        System.out.println(ans);
    }

    //Approach 1, with a map (extra space)
//    public static void helper(int[] nums, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds, boolean[] freq ){
//        if(ds.size() == nums.length){
//            ans.add(new ArrayList<>(ds));
//            return;
//        }
//
//        for(int i=0; i<nums.length; i++){
//            if(!freq[i]){
//                freq[i] = true;
//                ds.add(nums[i]);
//                helper(nums, ans, ds, freq);
//                ds.remove(ds.size() - 1);
//                freq[i] = false;
//            }
//        }
//    }


    //Approach 2, swapping technique
    public static void helper(int[] nums, int ind, ArrayList<ArrayList<Integer>> ans){
        if(ind==nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            ans.add(list);
            return;
        }

        for(int i=ind; i<nums.length; i++){
            int temp = nums[ind];
            nums[ind] = nums[i];
            nums[i] = temp;
            helper(nums, ind+1, ans);
            nums[i] = nums[ind];
            nums[ind] = temp;
        }
    }
}
