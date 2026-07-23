package VII_Recursion.II_Medium;

import java.util.ArrayList;

public class PrintAllSubsequencesWhoseSumIsK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int target = 2;

        printAllSubsequences(0, arr, 0, target, new ArrayList<>());

    }

    private static void printAllSubsequences(int i, int[] arr, int sum, int target, ArrayList<Integer> list){
        if(i == arr.length){
            if(sum == target){
                for(int j=0; j<list.size(); j++){
                    System.out.print(+list.get(j) + "  ");

                }
                System.out.println();
            }
            return;
        }

        list.add(arr[i]);
        printAllSubsequences(i+1, arr, sum+arr[i], target, list);

        list.remove(list.size()-1);
        printAllSubsequences(i+1, arr, sum, target, list);
    }



}
