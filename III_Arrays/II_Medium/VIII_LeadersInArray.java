package III_Arrays.II_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
public class VIII_LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        System.out.println(Arrays.toString(findLeaderBrute(arr).toArray()));
        System.out.println(Arrays.toString(findLeaderOptimal(arr).toArray()));
    }

    private static ArrayList<Integer> findLeaderOptimal(int[] arr) {
        int n = arr.length;

        // If there's only one element, it's the only leader
        if(n == 1){
            return new ArrayList<>(){{
                add(arr[0]);
            }};
        }

        int max = Integer.MIN_VALUE; // Initialize max to the smallest possible value
        ArrayList<Integer> list = new ArrayList<>();

        // Traverse from right to left (reverse order)
        for(int i = n - 1; i >= 0; i--) {
            // If current element is greater than all elements to its right
            if(arr[i] > max) {
                max = arr[i];       // Update max
                list.add(arr[i]);   // This element is a leader
            }
        }

        // Reverse the list to restore the order (since we traversed from end)
        Collections.reverse(list); // O(n)

        return list;
    }


    private static ArrayList<Integer> findLeaderBrute(int[] arr){
        //Brute force
        //O(N^2)
        int n = arr.length;
        if(n == 1){
            return new ArrayList<>(){{
                add(arr[0]);
            }};
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            boolean leader = true;
            for(int j=i+1; j<n; j++ ){
                if(arr[i] < arr[j]) {
                    leader = false;
                    break;
                }
            }
            if(leader){
                list.add(arr[i]);
            }
        }
        list.add(arr[n-1]);
        return list;
    }
}
