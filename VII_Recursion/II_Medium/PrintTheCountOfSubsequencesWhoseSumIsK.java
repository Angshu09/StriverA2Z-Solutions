package VII_Recursion.II_Medium;

import java.util.ArrayList;

public class PrintTheCountOfSubsequencesWhoseSumIsK {
    public static void main(String[] args) {

        int[] arr = {1, 2, 1};
        int target = 2;
        System.out.println(printSubsequenceCount(0, arr, 0, target, new ArrayList<>()));

    }
    private static int printSubsequenceCount(int i, int[] arr, int sum, int target, ArrayList<Integer> list){
        if(i == arr.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        list.add(arr[i]);
        int left = printSubsequenceCount(i+1, arr, sum+arr[i], target, list);
        list.remove(list.size() - 1);
        int right = printSubsequenceCount(i+1, arr, sum, target, list);

        return left+right;
    }
}
