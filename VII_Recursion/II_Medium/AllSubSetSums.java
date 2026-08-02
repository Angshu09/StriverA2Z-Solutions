package VII_Recursion.II_Medium;
//https://www.geeksforgeeks.org/problems/subset-sums2234/1


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllSubSetSums {
    public static void main(String[] args) {
        int[] arr = {2, 3};
        ArrayList<Integer> ans = new ArrayList<>();
        generateAllSubSetSums(arr, 0, 0, ans);
        Collections.sort(ans);
        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }

    private static void generateAllSubSetSums(int[] arr, int i, int sum, ArrayList<Integer> ans){
        if(i == arr.length){
            ans.add(sum);
            return;

        }

        sum+=arr[i];
        generateAllSubSetSums(arr, i+1, sum, ans);

        sum-=arr[i];
        generateAllSubSetSums(arr, i+1, sum, ans);
    }
}
