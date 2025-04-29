package III_Arrays.I_Easy;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

import java.util.Arrays;

public class IV_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 2, 3, 3, 4};
        int noOfUniques = removeDuplicate2(arr);
        System.out.println(noOfUniques);
        System.out.println(Arrays.toString(arr));
    }

    //Approach 1
    private static int removeDuplicate1(int[] arr){
        int n = arr.length;
        if(n == 1){
            return 1;
        }

        int i=0, j=0;
        int count = 1;

        while(j < n){
            if(arr[j] == arr[i]){
                j++;
            }
            else{
               i++;
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               j++;
               count++;
            }
        }

        return count;
    }

    //Approach 2
    private static int removeDuplicate2(int[] nums){
         int n = nums.length;
         int i = 0; //It points to the first element of the array

         for(int j=1; j<n; j++){
             if(nums[j] != nums[i]){ //If the current element is != with the element of index i
                 nums[i+1] = nums[j]; //Then put the current item in the i+1 place becuase the array is sorted
                 i++; //Then simply just increase the i
             }
         }

         return i+1;
    }

}
